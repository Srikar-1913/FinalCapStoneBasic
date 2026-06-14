package com.wipro.doconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doconnect.dto.ChatMessageDto;
import com.wipro.doconnect.entity.ChatMessage;
import com.wipro.doconnect.service.ChatMessageService;

@RestController
@RequestMapping("/chatmessages")
public class ChatMessageController {

	@Autowired
	private ChatMessageService chatMessageService;

	@PostMapping("/save")
	public ChatMessage saveMessage(@RequestBody ChatMessageDto chatMessageDto) {

		return chatMessageService.saveMessage(chatMessageDto);
	}

	@GetMapping("/getAll")
	public List<ChatMessage> getAllMessages() {

		return chatMessageService.getAllMessages();
	}

	@GetMapping("/get/{messageId}")
	public ChatMessage getMessageById(@PathVariable Long messageId) {

		return chatMessageService.getMessageById(messageId);
	}

	@PutMapping("/update/{messageId}")
	public ChatMessage updateMessage(@PathVariable Long messageId, @RequestBody ChatMessageDto chatMessageDto) {

		return chatMessageService.updateMessage(messageId, chatMessageDto);
	}

	@DeleteMapping("/delete/{messageId}")
	public String deleteMessage(@PathVariable Long messageId) {

		chatMessageService.deleteMessage(messageId);

		return "Message Deleted Successfully";
	}
}
