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
@RequestMapping(value ="bestcampsite")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model){
        User user = new User();
        model.addAttribute(user);
        return "Login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processLogin(Model model, @RequestParam String username,
                               @RequestParam String password){
        User user = userService.findUserByUsername(username);
        if(password.equals(user.getPassword())){
            return "Login";
        }
        return "Search";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.GET)
    public String createAccount(Model model){
       User user = new User();
        model.addAttribute(user);
       return "CreateAccount";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        User existingUser = userService.findUserByUsername(user.getUsername());
        if(existingUser != null){
            bindingResult.rejectValue("username", "error.username",
                                    "There is already a user with that name.");
        }
        if(bindingResult.hasErrors()){
            return "CreateAccount";
        } else {
            userService.saveUser(user);
            model.addAttribute("user", new User());
        }
        return "Search";
    }

    @RequestMapping(value = "search")
        public String search(Model model){
            return "Search";
    }
}
