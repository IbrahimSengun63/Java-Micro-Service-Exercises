package com.ibrahim.notificationservice.business.abstracts;

import com.ibrahim.common.dtos.notificationservice.requests.RequestAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseGetNotification;

public interface NotificationService {
    ResponseAddNotification addNotification(RequestAddNotification requestAddNotification);
    ResponseGetNotification getNotification(String id);
}
