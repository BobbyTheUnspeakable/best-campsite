package com.bestcampsite.bestcampsite.models.DAOs;

import com.bestcampsite.bestcampsite.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {
}