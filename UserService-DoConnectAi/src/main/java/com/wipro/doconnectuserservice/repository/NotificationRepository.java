package com.wipro.doconnectuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wipro.doconnectuserservice.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
