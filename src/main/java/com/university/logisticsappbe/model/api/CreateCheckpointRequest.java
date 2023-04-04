package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateCheckpointRequest {

        private Long routeId;
        private String description;
        private LocalDateTime date;
}
