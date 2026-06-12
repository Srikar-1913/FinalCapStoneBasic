package com.wipro.doconnectchatservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doconnectchatservice.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{

}
