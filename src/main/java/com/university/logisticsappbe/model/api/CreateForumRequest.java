package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateForumRequest {
    private String title;
    private String body;
    private String createdBy;
}
