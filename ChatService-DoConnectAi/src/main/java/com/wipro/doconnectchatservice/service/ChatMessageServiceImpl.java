package com.wipro.doconnectchatservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnectchatservice.ChatMessageRepository;
import com.wipro.doconnectchatservice.dto.ChatMessageDto;
import com.wipro.doconnectchatservice.entity.ChatMessage;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {
	
	@Autowired
	private ChatMessageRepository chatMessageRepository;

	@Override
	public ChatMessage saveMessage(ChatMessageDto chatMessageDto) {
		
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setMessage(chatMessageDto.getMessage());
		chatMessage.setSentAt(LocalDateTime.now());
		
		return chatMessageRepository.save(chatMessage);
	}

	@Override
	public List<ChatMessage> getAllMessages() {
		
		return chatMessageRepository.findAll();
	}

	@Override
	public ChatMessage getMessageByid(Long messageId) {
		
		return chatMessageRepository.findById(messageId).orElse(null);
	}

	@Override
	public ChatMessage updateMessage(Long messageid, ChatMessageDto chatMessageDto) {
		
		ChatMessage existingMessage = chatMessageRepository.findById(messageid).orElse(null);
		
		if (existingMessage != null) {
			existingMessage.setMessage(chatMessageDto.getMessage());
			
			return chatMessageRepository.save(existingMessage);
		}
		
		return null;
	}

	@Override
	public void deleteMessage(Long messageId) {
		
		chatMessageRepository.deleteById(messageId);
	}

}
