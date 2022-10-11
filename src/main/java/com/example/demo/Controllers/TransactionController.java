package com.example.demo.Controllers;

import com.example.demo.Model.Transaction;
import com.example.demo.Model.User;
import com.example.demo.Repo.TransactionRepository;
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

@Controller
public class TransactionController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transaction")
    public String Transact(@ModelAttribute("Trans") Transaction transaction, Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "transaction";
    }

    @PostMapping("/add-transaction")
    public String createTransaction(@ModelAttribute("Trans")@Valid Transaction transaction,
                             @RequestParam String username,
                             BindingResult bindingResult)
    {
        User user = userRepository.findByUsername(username);
        transaction.setUser(user);
        if(bindingResult.hasErrors())
        {
            return "transaction";
        }
        transactionRepository.save(transaction);
        return "redirect:/transaction";}


}
