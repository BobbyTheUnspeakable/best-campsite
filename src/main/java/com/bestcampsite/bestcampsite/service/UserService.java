package com.bestcampsite.bestcampsite.service;

import com.bestcampsite.bestcampsite.models.User;

public interface UserService {
    public User findUserByUsername(String username);
    public void saveUser(User user);
}
