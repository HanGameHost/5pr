package com.example.demo.Controllers;

import com.example.demo.Model.Accountingreport;
import com.example.demo.Model.Operation;
import com.example.demo.Model.Sotrudnik;
import com.example.demo.Model.Systemrepodting;
import com.example.demo.Repo.AccountingreportRepository;
import com.example.demo.Repo.OperationRepository;
import com.example.demo.Repo.SotrudnikRepository;
import com.example.demo.Repo.SystemrepodtingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private SotrudnikRepository sotrudnikRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private SystemrepodtingRepository systemrepodtingRepository;


    @Autowired
    private AccountingreportRepository accountingreportRepository;


    @GetMapping("/")
    public String greeting(Model model) {

        return "Main";
    }


    @GetMapping("/Main")
    public String success(Authentication authentication, Model model)
    {
        String role = authentication.getAuthorities().toString();
        System.out.print(role);

        if(role.contains("USER"))
        {
            Iterable<Operation> operations = operationRepository.findAll();
            model.addAttribute("operations", operations);
            return "Main";
        }
        else if(role.contains("SOTRUDNIK"))
        {
            Iterable<Systemrepodting> systemrepodtings = systemrepodtingRepository.findAll();
            model.addAttribute("systemrepodtings", systemrepodtings);

            Iterable<Accountingreport> accountingreports = accountingreportRepository.findAll();
            model.addAttribute("accountingreports", accountingreports);

            Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails)user).getUsername();
            System.out.print(username);
            return "Main_Sotrudnik";
        }
        else if(role.contains("ADMIN"))
        {
            Iterable<Sotrudnik> posts = sotrudnikRepository.findAll();
            model.addAttribute("posts", posts);
            return "MainAdmin";
        }

        return "redirect:/";
    }



    @GetMapping("/Sotr/Main-Sotrudnik")
    public String greeting2(Model model) {

        return "Main_Sotrudnik";
    }
}
