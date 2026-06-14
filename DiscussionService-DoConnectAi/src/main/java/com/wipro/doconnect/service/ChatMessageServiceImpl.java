package com.wipro.doconnect.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.dto.ChatMessageDto;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.ChatMessage;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exceptions.AnswerNotFoundException;
import com.wipro.doconnect.exceptions.ChatMessageNotFoundException;
import com.wipro.doconnect.exceptions.UserNotFoundException;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.ChatMessageRepository;
import com.wipro.doconnect.repository.UserRepository;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

	@Autowired
	private ChatMessageRepository chatMessageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public ChatMessage saveMessage(ChatMessageDto chatMessageDto) {

		ChatMessage chatMessage = new ChatMessage();

		chatMessage.setMessage(chatMessageDto.getMessage());
		chatMessage.setSentAt(LocalDateTime.now());

		User user = userRepository.findById(chatMessageDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + chatMessageDto.getUserId()));

		chatMessage.setUser(user);

		Answer answer = answerRepository.findById(chatMessageDto.getAnswerId()).orElseThrow(
				() -> new AnswerNotFoundException("Answer not found with id: " + chatMessageDto.getAnswerId()));

		chatMessage.setAnswer(answer);

		return chatMessageRepository.save(chatMessage);
	}

	@Override
	public List<ChatMessage> getAllMessages() {
		return chatMessageRepository.findAll();
	}

	@Override
	public ChatMessage getMessageById(Long messageId) {
		return chatMessageRepository.findById(messageId)
				.orElseThrow(() -> new ChatMessageNotFoundException("Message not found with id : " + messageId));
	}

	@Override
	public ChatMessage updateMessage(Long messageId, ChatMessageDto chatMessageDto) {

		ChatMessage existingMessage = chatMessageRepository.findById(messageId)
				.orElseThrow(() -> new ChatMessageNotFoundException("Message not found with id : " + messageId));

		existingMessage.setMessage(chatMessageDto.getMessage());

		return chatMessageRepository.save(existingMessage);
	}

	@Override
	public void deleteMessage(Long messageId) {

		ChatMessage chatMessage = chatMessageRepository.findById(messageId)
				.orElseThrow(() -> new ChatMessageNotFoundException("Message not found with id : " + messageId));

		chatMessageRepository.delete(chatMessage);
	}
}