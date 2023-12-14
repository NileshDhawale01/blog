package com.nsd.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
