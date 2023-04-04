package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateRouteRequest {
    private Long assignedUserId;
    private String pointA;
    private String pointB;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}
