package com.example.pafassessment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import com.example.pafassessment.model.Userdata;
import com.example.pafassessment.repository.AccountsRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FundsTransferController {
    
    // @Autowired
    //service

    @Autowired
    AccountsRepository repo;
    
    @GetMapping(path={"/", "/index.html"})
	public String myPage(Model model, HttpSession sess) {
        sess.invalidate();
        List<String> names = repo.getNameWithId();
        model.addAttribute("names", names);
        System.out.println("names>>>>" + names);
		return "index";
	}
    
    @PostMapping(path="/transfer")
    public String transfer(Model model, HttpSession sess, @Valid Userdata userdata, BindingResult bindings) {

        String transactionId = UUID.randomUUID().toString().substring(0, 8);
        //some checks done in model

        //yet to finish C0, C1 and C2
        // if (FromAcc == ToAcc){
        //     show error;
        // }


        if (bindings.hasErrors())
			return "index";

        return "transfer";
    }
}
