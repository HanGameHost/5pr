package com.example.demo.Controllers;

import com.example.demo.Model.Duty;
import com.example.demo.Model.Onlinewallet;
import com.example.demo.Model.Sotrudnik;
import com.example.demo.Model.User;
import com.example.demo.Repo.DutyRepository;
import com.example.demo.Repo.OnlinewalletRepository;
import com.example.demo.Repo.SotrudnikRepository;
import com.example.demo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DutyRepository dutyRepository;
    @Autowired
    private SotrudnikRepository sotrudnikRepository;
    @Autowired
    private OnlinewalletRepository onlinewalletRepository;
    @GetMapping("/sotrudnik/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Sotrudnik sotrudnik1, Model model) {
        Optional<Sotrudnik> sotrudnik = sotrudnikRepository.findById(id);
        ArrayList<Sotrudnik> res = new ArrayList<>();
        sotrudnik.ifPresent(res::add);
        model.addAttribute("res", res);
        if(!sotrudnikRepository.existsById(id)) {return "redirect:/Main";}
        return "sotrudnik-details";}

    @GetMapping("/sotrudnik/{id}/edit")
    public String blogEdit(@PathVariable("id")long id, @ModelAttribute("Sotr") Sotrudnik sotrudnik, Model model)
    {if(!sotrudnikRepository.existsById(id)){return "redirect:/";}
        Iterable<Duty> duty = dutyRepository.findAll();
        model.addAttribute("duty",duty);
        Sotrudnik posts = sotrudnikRepository.findById(id).orElseThrow(()
                ->new IllegalArgumentException("Invalid users Id" + id));
        model.addAttribute("posts", posts);
        return "sotrudnik-edit";
    }

    @PostMapping("/sotrudnik/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("Sotr")@Valid  Sotrudnik sotrudnik, @RequestParam String nameDuty, BindingResult bindingResult,
                                 @PathVariable("id") Long id, @Valid User user) {
        sotrudnik.setId(id);
        Duty duty = dutyRepository.findByNameDuty(nameDuty);
        sotrudnik.setDuty(duty);
        user.setId(id);
        Onlinewallet onlinewallet = onlinewalletRepository.findByNamewell("MirWallet");
        user.setOnlinewallet(onlinewallet);
        user.setActive(true);
        if (bindingResult.hasErrors()) {
            return "sotrudnik-edit";
        }
        sotrudnikRepository.save(sotrudnik);
        userRepository.save(user);
        return "redirect:/Main";}

    @PostMapping("/sotrudnik/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") Long id, Model model){
        Sotrudnik sotrudnik = sotrudnikRepository.findById(id).orElseThrow();
        String username = sotrudnik.getUsername();
        User user = userRepository.findByUsername(username);
        sotrudnik = sotrudnikRepository.findByUsername(username);
        sotrudnikRepository.delete(sotrudnik);
        userRepository.delete(user);

        return "redirect:/Main";}

    @GetMapping("/sotrudnik/filter")
    public String blogFilterUser(Model model)
    {
        Iterable<Sotrudnik> sotrudniks = sotrudnikRepository.findAll();
        model.addAttribute("result", sotrudniks);
        return "sotrudnik-filter";
    }
    @PostMapping("/sotrudnik/filter/result")
    public String blogUserResult(@RequestParam String surname, Model model) {
        List<Sotrudnik> result = sotrudnikRepository.findBySurname(surname);
        model.addAttribute("result", result);
        return "sotrudnik-filter";}
}
