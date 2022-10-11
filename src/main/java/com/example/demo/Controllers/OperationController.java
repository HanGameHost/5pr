package com.example.demo.Controllers;

import com.example.demo.Model.*;
import com.example.demo.Repo.CryptocurrencyRepository;
import com.example.demo.Repo.OperationRepository;
import com.example.demo.Repo.TypeopeationRepository;
import com.example.demo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class OperationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    private TypeopeationRepository typeopeationRepository;
    @Autowired
    private OperationRepository operationRepository;
    @GetMapping("/operation")
    public String Buhgalteriya(@ModelAttribute("Oper") Operation operation, Model model){
        Iterable<Cryptocurrency> cryptocurrencies = cryptocurrencyRepository.findAll();
        model.addAttribute("cryptocurrencies",cryptocurrencies);

        Iterable<Typeopeation> typeopeations = typeopeationRepository.findAll();
        model.addAttribute("typeopeations",typeopeations);
        return "operation";
    }

    @PostMapping("/add-operation")
    public String createUser(@ModelAttribute("Oper")@Valid Operation operation,
                             @RequestParam String name, @RequestParam String nameoperation,
                             BindingResult bindingResult)
    {
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findByName(name);
        Typeopeation typeopeation = typeopeationRepository.findBynameoperation(nameoperation);
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)user).getUsername();
        System.out.print(username);
        User user1 = userRepository.findByUsername(username);
        operation.setUser(user1);
        operation.setCryptocurrency(cryptocurrency);
        operation.setTypeoperation(typeopeation);
        if(bindingResult.hasErrors())
        {
            return "operation";
        }
        operationRepository.save(operation);
        return "redirect:/operation";}
}
