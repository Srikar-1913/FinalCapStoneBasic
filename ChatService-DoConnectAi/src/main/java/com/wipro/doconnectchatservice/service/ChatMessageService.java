package com.wipro.doconnectchatservice.service;

import java.util.List;

import com.wipro.doconnectchatservice.dto.ChatMessageDto;
import com.wipro.doconnectchatservice.entity.ChatMessage;

public interface ChatMessageService {
	ChatMessage saveMessage(ChatMessageDto chatMessageDto);
	
	List<ChatMessage> getAllMessages();
	
	ChatMessage getMessageByid(Long messageId);
	
	ChatMessage updateMessage(Long messageid, ChatMessageDto chatMessageDto);
	
	void deleteMessage(Long messageId);
}
