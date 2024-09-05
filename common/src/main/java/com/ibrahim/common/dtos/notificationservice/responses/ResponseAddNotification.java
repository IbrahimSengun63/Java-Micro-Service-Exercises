package com.ibrahim.common.dtos.notificationservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAddNotification {
    private String id;
    private String message;
}
