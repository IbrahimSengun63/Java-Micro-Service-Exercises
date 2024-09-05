package com.ibrahim.notificationservice.dataAccess;

import com.ibrahim.notificationservice.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
