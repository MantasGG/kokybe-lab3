package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCommentRequest {
    private Long forumId;
    private Long replyId;
    private String comment;
    private String createdBy;
}
