package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Setter
@Getter
public class StatusCountResponse {
    private String status;
    private BigInteger statusCount;
}
