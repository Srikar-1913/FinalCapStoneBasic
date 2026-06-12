package com.wipro.doconnectchatservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnectchatservice.ChatMessageRepository;
import com.wipro.doconnectchatservice.dto.ChatMessageDto;
import com.wipro.doconnectchatservice.entity.ChatMessage;
import com.wipro.doconnectchatservice.exceptions.ChatMessageNotFoundException;

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

        return chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new ChatMessageNotFoundException(
                        "Message not found with id : " + messageId));
    }

    @Override
    public ChatMessage updateMessage(Long messageId,
                                     ChatMessageDto chatMessageDto) {

        ChatMessage existingMessage =
                chatMessageRepository.findById(messageId)
                        .orElseThrow(() -> new ChatMessageNotFoundException(
                                "Message not found with id : " + messageId));

        existingMessage.setMessage(chatMessageDto.getMessage());

        return chatMessageRepository.save(existingMessage);
    }

    @Override
    public void deleteMessage(Long messageId) {

        ChatMessage chatMessage =
                chatMessageRepository.findById(messageId)
                        .orElseThrow(() -> new ChatMessageNotFoundException(
                                "Message not found with id : " + messageId));

        chatMessageRepository.delete(chatMessage);
    }
}