package com.university.logisticsappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "CHECKPOINTS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoCheckpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ROUTE_ID", nullable = false)
    private Long routeId;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;
}
