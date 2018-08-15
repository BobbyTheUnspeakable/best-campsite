package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.DAOs.UserDAO;
import com.bestcampsite.bestcampsite.models.User.User;
import com.bestcampsite.bestcampsite.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        String cookie = userCookie();
        model.addAttribute("user", cookie);
        model.addAttribute("loginStatus", checkLoginStatus(cookie));
        return "Login";
    }

    public User authUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(authentication.getName());
        return user;
    }

    public String userCookie(){
        String cookie = "";
        User authUser = authUser();
        if(authUser != null){
            cookie = authUser.getUsername();
        }
        return cookie;
    }

    public boolean checkLoginStatus(String userCookie){
        boolean loggedInStatus = false;
        if(!userCookie.equals("")){
            loggedInStatus = true;
        }
        return loggedInStatus;
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
            String cookie = userCookie();
            model.addAttribute("user", cookie);
            model.addAttribute("loginStatus", checkLoginStatus(cookie));
        }
        return "Search";
    }

    @RequestMapping(value = "search")
        public String search(Model model){
            return "Search";
    }
}
