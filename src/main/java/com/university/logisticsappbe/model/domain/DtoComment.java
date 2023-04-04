package com.university.logisticsappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "COMMENT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FORUM_ID")
    private Long forumId;

    @Column(name = "REPLY_ID")
    private Long replyId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "CREATED_BY")
    private String createdBy;
}
