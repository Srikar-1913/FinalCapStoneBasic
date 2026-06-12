package com.wipro.doconnectuserservice.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnectuserservice.dto.NotificationDto;
import com.wipro.doconnectuserservice.entity.Notification;
import com.wipro.doconnectuserservice.exceptions.NotificationNotFoundException;
import com.wipro.doconnectuserservice.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Add Notification
    @Override
    public NotificationDto addNotification(NotificationDto notificationDto) {

        Notification notification = convertToEntity(notificationDto);

        notification.setCreatedAt(LocalDateTime.now());

        Notification savedNotification =
                notificationRepository.save(notification);

        return convertToDto(savedNotification);
    }

    // Get Notification By Id
    @Override
    public NotificationDto getNotificationById(Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                .orElseThrow(() ->
                        new NotificationNotFoundException(
                                "Notification not found with id : "
                                        + notificationId));

        return convertToDto(notification);
    }

    // Get All Notifications
    @Override
    public List<NotificationDto> getAllNotifications() {

        return notificationRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Update Notification
    @Override
    public NotificationDto updateNotification(Long notificationId,
                                              NotificationDto notificationDto) {

        Notification existingNotification =
                notificationRepository.findById(notificationId)
                .orElseThrow(() ->
                        new NotificationNotFoundException(
                                "Notification not found with id : "
                                        + notificationId));

        updateEntity(existingNotification, notificationDto);

        Notification updatedNotification =
                notificationRepository.save(existingNotification);

        return convertToDto(updatedNotification);
    }

    // Delete Notification
    @Override
    public String deleteNotification(Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                .orElseThrow(() ->
                        new NotificationNotFoundException(
                                "Notification not found with id : "
                                        + notificationId));

        notificationRepository.delete(notification);

        return "Notification deleted successfully";
    }

    // Convert DTO to Entity
    private Notification convertToEntity(NotificationDto notificationDto) {

        Notification notification = new Notification();

        notification.setMessage(notificationDto.getMessage());
        notification.setStatus(notificationDto.getStatus());

        return notification;
    }

    // Convert Entity to DTO
    private NotificationDto convertToDto(Notification notification) {

        NotificationDto dto = new NotificationDto();

        dto.setNotificationId(notification.getNotificationId());
        dto.setMessage(notification.getMessage());
        dto.setStatus(notification.getStatus());

        return dto;
    }

    // Update Entity values
    private void updateEntity(Notification notification,
                              NotificationDto notificationDto) {

        notification.setMessage(notificationDto.getMessage());
        notification.setStatus(notificationDto.getStatus());
    }
}
