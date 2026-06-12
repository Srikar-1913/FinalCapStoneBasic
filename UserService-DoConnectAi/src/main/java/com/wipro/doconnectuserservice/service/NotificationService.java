package com.wipro.doconnectuserservice.service;


import java.util.List;

import com.wipro.doconnectuserservice.dto.NotificationDto;

public interface NotificationService {

    NotificationDto addNotification(NotificationDto notificationDto);

    NotificationDto getNotificationById(Long notificationId);

    List<NotificationDto> getAllNotifications();

    NotificationDto updateNotification(Long notificationId,
                                       NotificationDto notificationDto);

    String deleteNotification(Long notificationId);
}
