package com.wipro.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doconnect.entity.Impression;

public interface ImpressionRepository extends JpaRepository<Impression, Long> {

    
}