package com.wipro.doconnectuserservice.controller;


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

import com.wipro.doconnectuserservice.dto.NotificationDto;
import com.wipro.doconnectuserservice.service.NotificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Add Notification
    @PostMapping
    public NotificationDto addNotification(
            @Valid @RequestBody NotificationDto notificationDto) {

        return notificationService.addNotification(notificationDto);
    }

    // Get Notification By Id
    @GetMapping("/{notificationId}")
    public NotificationDto getNotificationById(
            @PathVariable Long notificationId) {

        return notificationService.getNotificationById(notificationId);
    }

    // Get All Notifications
    @GetMapping
    public List<NotificationDto> getAllNotifications() {

        return notificationService.getAllNotifications();
    }

    // Update Notification
    @PutMapping("/{notificationId}")
    public NotificationDto updateNotification(
            @PathVariable Long notificationId,
            @Valid @RequestBody NotificationDto notificationDto) {

        return notificationService.updateNotification(
                notificationId,
                notificationDto);
    }

    // Delete Notification
    @DeleteMapping("/{notificationId}")
    public String deleteNotification(
            @PathVariable Long notificationId) {

        return notificationService.deleteNotification(notificationId);
    }
}
