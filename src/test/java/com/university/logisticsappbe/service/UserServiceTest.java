package com.university.logisticsappbe.service;

import com.university.logisticsappbe.model.api.CreateUserRequest;
import com.university.logisticsappbe.model.domain.DtoUser;
import com.university.logisticsappbe.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    public UserServiceTest() {

    }

    @Test
    void whenUserCreated_ShouldReturnEncryptedPassword() {
        String password = "password";
        CreateUserRequest request = new CreateUserRequest(
                "firstName",
                "lastName",
                "male",
                "email@email.email",
                "+37011111111",
                password,
                "manager",
                "address");

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserService(repository);

        DtoUser actual = service.createUser(request);

        assertNotEquals(password, actual.getPassword());
    }
}