package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.DAOs.UserDAO;
import com.bestcampsite.bestcampsite.models.User;
import com.bestcampsite.bestcampsite.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("bestcampsite")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("")
    public String login(Model model){
        model.addAttribute(new User());
        return "Login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processLogin(Model model, @RequestParam String username,
                               @RequestParam String password){
        UserDetails user = userService.loadUserByUsername(username);
        /** Take the username and feed if to userService
         * If the given username doesn't throw an exception validate the password
         * If the username does throw an exception reload the form with error message
         */
        //if(password != user.getPassword()){ }
        return "Search";
    }

    @RequestMapping(value = "createAccount")
    public String createAccount(Model model){
       User user = new User();
        model.addAttribute(user);
       return "CreateAccount";
    }

    /*@RequestMapping(value = "createAccount")
    public String addUser(@Valid templates user, BindingResult bindingResult){
        templates existingUser = userService.findUserByUsername(user.getUsername());
        if(existingUser != null){
            bindingResult.rejectValue("username","error.user",
                    "Someone beat you to that Username!");
        }
        if(bindingResult.hasErrors()){
            return "templates/CreateAccount";
        } else {
            userService.saveUser(user);
            return "templates/Login"; //TODO Change this to the search page when built
        }
    }*/

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify){
        if(user.getPassword().equals(verify)){
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            userDAO.save(newUser);
            return "Search";
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("error", "Passwords do not match");
            return "CreateAccount";
        }
    }
}
