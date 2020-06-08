package com.sarg.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarg.tutorial.model.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

	
}
