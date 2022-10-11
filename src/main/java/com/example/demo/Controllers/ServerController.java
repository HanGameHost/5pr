package com.example.demo.Controllers;

import com.example.demo.Model.Protection;
import com.example.demo.Model.Provider;
import com.example.demo.Model.Server;
import com.example.demo.Repo.ProtectionRepository;
import com.example.demo.Repo.ProviderRepository;
import com.example.demo.Repo.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ServerController {
    @Autowired
    private ProtectionRepository protectionRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ServerRepository serverRepository;

    @GetMapping("/servers")
    public String Server(@ModelAttribute("Serv") Server server, Model model){
        Iterable<Protection> protections = protectionRepository.findAll();
        model.addAttribute("protections",protections);

        Iterable<Provider> providers = providerRepository.findAll();
        model.addAttribute("providers",providers);
        return "server";
    }

    @PostMapping("/servers")
    public String addServer(@ModelAttribute("Serv")@Valid Server server,
                          BindingResult bindingResult,
                          @RequestParam String levelprotection, @RequestParam String name){

        Protection protection = protectionRepository.findBylevelprotection(levelprotection);
        Provider provider = providerRepository.findByName(name);
        server.setProtection(protection);
        server.setProvider(provider);

        if(bindingResult.hasErrors())
        {
            return "redirect:/servers";
        }
        serverRepository.save(server);
        return "server";
    }


}
