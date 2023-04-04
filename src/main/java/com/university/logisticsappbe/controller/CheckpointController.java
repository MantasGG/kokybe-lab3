package com.university.logisticsappbe.controller;

import com.university.logisticsappbe.model.api.CreateCheckpointRequest;
import com.university.logisticsappbe.model.api.CreateRouteRequest;
import com.university.logisticsappbe.model.domain.DtoCheckpoint;
import com.university.logisticsappbe.service.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CheckpointController {
    private final CheckpointService checkpointService;

    @Autowired
    public CheckpointController(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @GetMapping(path = "/checkpoints/{id}")
    public List<DtoCheckpoint> fetchCheckpointsByRouteId(@PathVariable Long id){
        return checkpointService.fetchCheckpointsByRouteId(id);
    }

    @GetMapping(path = "/checkpoints")
    public List<DtoCheckpoint> fetchCheckpoints(){
        return checkpointService.fetchCheckpoints();
    }

    @PostMapping(path = "/checkpoints")
    public Long createCheckpoint(@Validated @RequestBody CreateCheckpointRequest request){
        return checkpointService.createCheckpoint(request).getId();
    }

    @PutMapping(path = "/checkpoints/{id}")
    public DtoCheckpoint updateCheckpoint(@Validated @RequestBody DtoCheckpoint checkpoint, @PathVariable Long id){
        return checkpointService.updateCheckpoint(checkpoint,id);
    }

    @DeleteMapping(value = "/checkpoints/{id}")
    public ResponseEntity<Void> deleteCheckpoint(@PathVariable Long id){
        checkpointService.deleteCheckpoint(id);
        return ResponseEntity.noContent().build();
    }
}
