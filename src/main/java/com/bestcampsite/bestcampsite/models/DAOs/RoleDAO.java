package com.bestcampsite.bestcampsite.models.DAOs;

import com.bestcampsite.bestcampsite.models.Role;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleDAO extends JpaRepository<Role, Integer>{
    Role findByRole(String role);
}
