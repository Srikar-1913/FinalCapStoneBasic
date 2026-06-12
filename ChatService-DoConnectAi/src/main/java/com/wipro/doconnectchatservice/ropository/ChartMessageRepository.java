package com.wipro.doconnectchatservice.ropository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.doconnectchatservice.entity.ChatMessage;

public interface ChartMessageRepository extends JpaRepository<ChatMessage, Long>{

}
