package com.university.logisticsappbe.service;

import com.university.logisticsappbe.model.api.CreateCheckpointRequest;
import com.university.logisticsappbe.model.api.CreateRouteRequest;
import com.university.logisticsappbe.model.domain.DtoCheckpoint;
import com.university.logisticsappbe.model.domain.DtoRoutes;
import com.university.logisticsappbe.repository.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointService {

    private final CheckpointRepository checkpointRepository;

    @Autowired
    public CheckpointService(CheckpointRepository checkpointRepository) {
        this.checkpointRepository = checkpointRepository;
    }

    public List<DtoCheckpoint> fetchCheckpointsByRouteId(Long id){
        return checkpointRepository.findAllByRouteId(id);
    }

    public DtoCheckpoint createCheckpoint(CreateCheckpointRequest request){
        DtoCheckpoint checkpoint = DtoCheckpoint.builder()
                .routeId(request.getRouteId())
                .description(request.getDescription())
                .date(request.getDate())
                .build();
        return checkpointRepository.save(checkpoint);
    }

    public DtoCheckpoint updateCheckpoint(DtoCheckpoint checkpoint, Long id){
        checkpoint.setId(id);
        return checkpointRepository.save(checkpoint);
    }

    public void deleteCheckpoint(Long id){
        checkpointRepository.deleteById(id);
    }

    public List<DtoCheckpoint> fetchCheckpoints() {
        return checkpointRepository.findAll();
    }
}
