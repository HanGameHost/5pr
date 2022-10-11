package com.example.demo.Controllers;

import com.example.demo.Model.*;
import com.example.demo.Repo.DutyRepository;
import com.example.demo.Repo.OnlinewalletRepository;
import com.example.demo.Repo.SotrudnikRepository;
import com.example.demo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OnlinewalletRepository onlinewalletRepository;
    @Autowired
    private DutyRepository dutyRepository;
    @Autowired
    private SotrudnikRepository sotrudnikRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user,Model model){
        Iterable<Onlinewallet> onlinewallet = onlinewalletRepository.findAll();
        model.addAttribute("onlinewallet",onlinewallet);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user")@Valid User user,
                          BindingResult bindingResult,
                          @RequestParam String namewell,
                          Model model){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        Onlinewallet onlinewallet = onlinewalletRepository.findByNamewell(namewell);
        user.setOnlinewallet(onlinewallet);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        Iterable<Onlinewallet> onlinewallet1 = onlinewalletRepository.findAll();
        model.addAttribute("onlinewallet",onlinewallet1);
        if(bindingResult.hasErrors())
        {

            return "registration";
        }
        if(userFromDb != null)
        {
            model.addAttribute("message", "Пользователь с таким логином уже зарегистрирован");
            return "registration";
        }


        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }








    @GetMapping("/registration-sotrudnik")
    public String registrationSotr(@ModelAttribute("sotrudnik") Sotrudnik sotrudnik,Model model){
        Iterable<Duty> duty = dutyRepository.findAll();
        model.addAttribute("duty",duty);
        return "registration_sotrudnik";
    }

    @PostMapping("/registration-sotrudnik")
    public String addSotr(@ModelAttribute("sotrudnik")@Valid Sotrudnik sotrudnik,
                          BindingResult bindingResult,
                          @RequestParam String nameDuty,
                          @ModelAttribute("Users")@Valid User user,
                          Model model){
        Sotrudnik sotrFromDb = sotrudnikRepository.findByUsername(sotrudnik.getUsername());
        Duty duty1 = dutyRepository.findByNameDuty(nameDuty);
        sotrudnik.setDuty(duty1);
        Iterable<Duty> duty = dutyRepository.findAll();
        model.addAttribute("duty",duty);

        User userFromDb = userRepository.findByUsername(user.getUsername());
        Onlinewallet onlinewallet = onlinewalletRepository.findByNamewell("MirWallet");
        user.setOnlinewallet(onlinewallet);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.SOTRUDNIK));

        if(bindingResult.hasErrors())
        {
            return "registration_sotrudnik";
        }
        if(userFromDb != null || sotrFromDb != null)
        {
            model.addAttribute("message", "сотрудник с таким логином уже зарегистрирован");
            return "registration_sotrudnik";
        }


        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        sotrudnikRepository.save(sotrudnik);
        userRepository.save(user);
        return "redirect:/";
    }
}
