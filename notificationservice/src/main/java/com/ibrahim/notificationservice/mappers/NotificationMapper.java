package com.ibrahim.notificationservice.mappers;

import com.ibrahim.common.dtos.notificationservice.requests.RequestAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseGetNotification;
import com.ibrahim.notificationservice.models.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notification requestAddNotificationToNotification(RequestAddNotification requestAddNotification);
    ResponseAddNotification notificationToResponseAddNotification(Notification notification);

    ResponseGetNotification notificationToResponseGetNotification(Notification notification);
}
