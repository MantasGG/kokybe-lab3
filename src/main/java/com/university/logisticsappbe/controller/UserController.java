package com.university.logisticsappbe.controller;

import com.university.logisticsappbe.model.api.CreateUserRequest;
import com.university.logisticsappbe.model.api.UserResponse;
import com.university.logisticsappbe.model.domain.DtoUser;
import com.university.logisticsappbe.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<UserResponse> fetchUsers(){
        return userService.fetchUsers().stream().map(p -> new UserResponse(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getGender(),
                p.getPhone(),
                p.getEmail(),
                p.getPassword(),
                p.getRole(),
                p.getAddress())).collect(Collectors.toList());
    }

    @PostMapping(path = "/registration")
    @ApiResponse(
            responseCode = "201",
            description = "New USER successfully created in DB",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    public Long createUser(@Validated @RequestBody CreateUserRequest request){
        return userService.createUser(request).getId();
    }

    @PutMapping(path = "/users/{id}")
    public DtoUser updateUser(@Validated @RequestBody DtoUser user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
