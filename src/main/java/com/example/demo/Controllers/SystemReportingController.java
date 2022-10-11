package com.example.demo.Controllers;

import com.example.demo.Model.Server;
import com.example.demo.Model.Sotrudnik;
import com.example.demo.Model.Systemrepodting;
import com.example.demo.Model.Tasks;
import com.example.demo.Repo.ServerRepository;
import com.example.demo.Repo.SotrudnikRepository;
import com.example.demo.Repo.SystemrepodtingRepository;
import com.example.demo.Repo.TasksRepository;
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
public class SystemReportingController {

    @Autowired
    private ServerRepository serverRepository;
    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private SotrudnikRepository sotrudnikRepository;
    @Autowired
    private SystemrepodtingRepository systemrepodtingRepository;

    @GetMapping("/system-reporting")
    public String Server(@ModelAttribute("System") Systemrepodting systemrepodting, Model model){
        Iterable<Server> servers = serverRepository.findAll();
        model.addAttribute("servers",servers);

        Iterable<Tasks> tasks = tasksRepository.findAll();
        model.addAttribute("tasks",tasks);
        return "system_reporting";
    }

    @PostMapping("/create-system-reporting")
    public String createUser(@ModelAttribute("System")@Valid Systemrepodting systemrepodting,
                             @RequestParam String ipaddress, @RequestParam String typetasks,
                             BindingResult bindingResult)
    {
        Server server = serverRepository.findByipaddress(ipaddress);
        Tasks tasks1 = tasksRepository.findBytypetasks(typetasks);
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)user).getUsername();
        System.out.print(username);
        Sotrudnik sotrudnik = sotrudnikRepository.findByUsername(username);
        systemrepodting.setServer(server);
        systemrepodting.setTasks(tasks1);
        systemrepodting.setSotrudnik(sotrudnik);
        if(bindingResult.hasErrors())
        {
            return "system_reporting";
        }
        systemrepodtingRepository.save(systemrepodting);
        return "redirect:/system-reporting";}
}
