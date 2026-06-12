package com.wipro.doconnectdiscussionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doconnectdiscussionservice.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
