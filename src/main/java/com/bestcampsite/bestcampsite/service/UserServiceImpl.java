package com.bestcampsite.bestcampsite.service;

import com.bestcampsite.bestcampsite.models.DAOs.RoleDAO;
import com.bestcampsite.bestcampsite.models.DAOs.UserDAO;
import com.bestcampsite.bestcampsite.models.User.Role;
import com.bestcampsite.bestcampsite.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByUsername(String username){
        return userDAO.findByUsername(username);
    }

    @Override
    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleDAO.findByRole("ADMIN");//TODO potentially "USER"
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userDAO.save(user);
    }

}
