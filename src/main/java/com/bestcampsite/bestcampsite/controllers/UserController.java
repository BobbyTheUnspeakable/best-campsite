package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.DAOs.UserDAO;
import com.bestcampsite.bestcampsite.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("bestcampsite")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "createAccount")
    public String createAccount(Model model){
       model.addAttribute(new User());
       return "User/CreateAccount";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify){
        if(user.getPassword().equals(verify)){
            userDAO.save(user);
            return "redirect:/bestcampsite/"; //TODO Change this to the Search Page once its built
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("error", "Passwords do not match");
            return "User/CreateAccount";
        }
    }
}
