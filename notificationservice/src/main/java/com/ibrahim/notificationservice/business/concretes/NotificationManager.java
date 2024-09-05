package com.ibrahim.notificationservice.business.concretes;

import com.ibrahim.common.dtos.notificationservice.requests.RequestAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseGetNotification;
import com.ibrahim.notificationservice.business.abstracts.NotificationService;
import com.ibrahim.notificationservice.dataAccess.NotificationRepository;
import com.ibrahim.notificationservice.mappers.NotificationMapper;
import com.ibrahim.notificationservice.models.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationManager implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public ResponseAddNotification addNotification(RequestAddNotification requestAddNotification) {
        Notification notification = notificationMapper.requestAddNotificationToNotification(requestAddNotification);
        Notification savedNotification = notificationRepository.save(notification);
        return notificationMapper.notificationToResponseAddNotification(savedNotification);
    }

    @Override
    public ResponseGetNotification getNotification(String id) {
        Notification notification = notificationRepository.findById(id).orElseThrow();
        return notificationMapper.notificationToResponseGetNotification(notification);
    }
}
