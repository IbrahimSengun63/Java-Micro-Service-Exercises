package com.ibrahim.notificationservice.webApi.controllers;

import com.ibrahim.common.dtos.notificationservice.requests.RequestAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseAddNotification;
import com.ibrahim.common.dtos.notificationservice.responses.ResponseGetNotification;
import com.ibrahim.notificationservice.business.abstracts.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification-service")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/add")
    public ResponseEntity<ResponseAddNotification> addNotification(@RequestBody RequestAddNotification requestAddNotification) {
        ResponseAddNotification response = notificationService.addNotification(requestAddNotification);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseGetNotification> getNotification(@PathVariable String id) {
        ResponseGetNotification responseGetNotification = notificationService.getNotification(id);
        return ResponseEntity.ok(responseGetNotification);
    }
}
