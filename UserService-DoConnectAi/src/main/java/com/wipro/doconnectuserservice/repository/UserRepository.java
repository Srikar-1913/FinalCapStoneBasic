package com.wipro.doconnectuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doconnectuserservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
