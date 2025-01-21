package com.example.serviceinventory.model;


import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Builder
@Getter
public class ErrorResponse {
    private List<Notification> notification;


    @Builder
    @Getter
    public static class Notification{
        private String category;
        private String code;
        private String message;
        private String description;
        private String action;
        private String metadata;
        private String uuid;
        private String timestamp;
        private String severity;
    }
}
