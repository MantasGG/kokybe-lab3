package com.university.logisticsappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "ROUTES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoRoutes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ASSIGNED_USER_ID")
    private Long assignedUserId;

    @Column(name = "POINT_A", nullable = false)
    private String pointA;

    @Column(name = "POINT_B", nullable = false)
    private String pointB;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "STATUS", nullable = false)
    private String status;
}
