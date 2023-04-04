package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<DtoUser, Long> {
    List<DtoUser> findAllByEmail(String email);
    Optional<DtoUser> findUserByEmail(String email);
}
