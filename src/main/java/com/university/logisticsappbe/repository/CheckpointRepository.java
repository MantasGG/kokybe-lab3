package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoCheckpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckpointRepository extends JpaRepository<DtoCheckpoint,Long> {
    List<DtoCheckpoint> findAllByRouteId(Long id);
}
