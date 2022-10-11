package com.example.demo.Controllers;

import com.example.demo.Model.Role;
import com.example.demo.Model.Sotrudnik;
import com.example.demo.Model.User;
import com.example.demo.Repo.SotrudnikRepository;
import com.example.demo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserWebController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SotrudnikRepository sotrudnikRepository;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("user", sotrudnikRepository.findAll());
        return "userList";
    }
    @GetMapping("/{id}/edit")
    public String userEdit(@PathVariable(value = "id") Long id, Model model){
        Optional<User> user1 = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user1.ifPresent(res::add);
        model.addAttribute("user", res);
        model.addAttribute("roles", Role.values());

        Optional<Sotrudnik> sotrudnik = sotrudnikRepository.findById(id);
        ArrayList<Sotrudnik> res2 = new ArrayList<>();
        sotrudnik.ifPresent(res2::add);
        model.addAttribute("user", res);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }



    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam(name="roles[]", required = false) String[] roles,
                           @RequestParam("userId") User user, Sotrudnik sotrudnik){
        user.setUsername(username);
        user.getRoles().clear();

        sotrudnik.setUsername(username);

        if(roles!=null)
        {
            Arrays.stream(roles).forEach(r->user.getRoles().add(Role.valueOf(r)));

        }
        userRepository.save(user);
        sotrudnikRepository.save(sotrudnik);
            return "redirect:/admin";

    }


}
