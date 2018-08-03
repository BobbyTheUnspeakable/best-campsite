package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("bestcampsite")
public class UserController {

    @RequestMapping(value = "createAccount")
    public String createAccount(Model model){
       model.addAttribute(new User());
       return "User/CreateAccount";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify){
        if(user.getPassword().equals(verify)){
            return "User/Login"; //TODO Change this to the Search Page once its built
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("error", "Passwords do not match");
            return "User/CreateAccount";
        }
    }
}
