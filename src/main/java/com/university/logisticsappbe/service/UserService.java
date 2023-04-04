package com.university.logisticsappbe.service;

import com.university.logisticsappbe.model.api.CreateUserRequest;
import com.university.logisticsappbe.model.domain.DtoUser;
import com.university.logisticsappbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<DtoUser> fetchUsers(){
        return userRepository.findAll();
    }

    public DtoUser createUser(CreateUserRequest request){
        DtoUser user = DtoUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .role(request.getRole())
                .address(request.getAddress())
                .build();

        return userRepository.save(user);
    }

    public DtoUser updateUser(DtoUser user, Long id){
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
