package com.university.logisticsappbe.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String gender;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private String password;
    private String role;
    private String address;
}
