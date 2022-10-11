package com.example.demo.Controllers;

import com.example.demo.Model.Accountingreport;
import com.example.demo.Model.Systemrepodting;
import com.example.demo.Model.Transaction;
import com.example.demo.Repo.AccountingreportRepository;
import com.example.demo.Repo.SystemrepodtingRepository;
import com.example.demo.Repo.TransactionRepository;
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
public class AccountingReportController {

    @Autowired
    SystemrepodtingRepository systemrepodtingRepository;

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountingreportRepository accountingreportRepository;


    @GetMapping("/buhgalteriya")
    public String Buhgalteriya(@ModelAttribute("Buhgalteriya") Accountingreport accountingreport, Model model){
        Iterable<Systemrepodting> systemrepodtings = systemrepodtingRepository.findAll();
        model.addAttribute("systemrepodtings",systemrepodtings);

        Iterable<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions",transactions);
        return "accountingreporting";
    }

    @PostMapping("/add-buhgalteriya")
    public String createTransaction(@ModelAttribute("Buhgalteriya")@Valid Accountingreport accountingreport,
                                    @RequestParam String numberofconnection, @RequestParam String totalnumberofoperation,
                                    BindingResult bindingResult)
    {
        Systemrepodting systemrepodting = systemrepodtingRepository.findBynumberofconnection(Integer.parseInt(numberofconnection));
        accountingreport.setSystemreporting(systemrepodting);

        Transaction transaction = transactionRepository.findBytotalnumberofoperation(Integer.parseInt(totalnumberofoperation));
        accountingreport.setTrancation(transaction);
        if(bindingResult.hasErrors())
        {
            return "accountingreporting";
        }
        accountingreportRepository.save(accountingreport);
        return "redirect:/buhgalteriya";}


}
