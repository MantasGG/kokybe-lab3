package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String email;
    private String password;
    private String role;
    private String address;
}
