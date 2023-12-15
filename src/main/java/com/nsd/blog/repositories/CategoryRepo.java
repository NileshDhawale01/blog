package com.nsd.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
