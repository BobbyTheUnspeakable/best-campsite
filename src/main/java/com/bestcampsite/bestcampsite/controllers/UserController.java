package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bestcampsite")
public class UserController {

    @RequestMapping(value = "createAccount")
    public String createAccount(Model model){
       model.addAttribute(new User());
       return "User/CreateAccount";
    }
}
