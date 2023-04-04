package com.university.logisticsappbe.controller;

import com.university.logisticsappbe.model.api.CreateRouteRequest;
import com.university.logisticsappbe.model.api.StatusCountResponse;
import com.university.logisticsappbe.model.domain.DtoRoutes;
import com.university.logisticsappbe.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class RoutesController {
    private final RoutesService routesService;

    @Autowired
    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @GetMapping(path = "/routes")
    public List<DtoRoutes> fetchRoutes(){
        return routesService.fetchRoutes();
    }

    @GetMapping(path = "/routes/{assignedUserId}")
    public List<DtoRoutes> fetchRoutesByEmail(@PathVariable Long assignedUserId){
        return routesService.fetchAllByAssignedUserId(assignedUserId);
    }

    @GetMapping(path = "/routes/notassigned")
    public List<DtoRoutes> fetchAllWhereAssignedUserIdIsNull(){
        return routesService.fetchAllWhereAssignedUserIdIsNull();
    }

    @GetMapping(path = "/routes/statuscount")
    public List<StatusCountResponse> fetchStatusCount(){
        List<StatusCountResponse> fetch = routesService.fetchStatusCount();
        List<StatusCountResponse> response = new ArrayList<>();
        for (Object element : fetch) {
            StatusCountResponse statusCountResponse = new StatusCountResponse();
            if (element instanceof Object[]) {
                Object[] elementArray = (Object[]) element;
                if (elementArray[0] instanceof String) {
                    statusCountResponse.setStatus((String) elementArray[0]);
                }
                statusCountResponse.setStatusCount((BigInteger) elementArray[1]);
            }
            response.add(statusCountResponse);
        }

        return response;
    }

    @PostMapping(path = "/routes")
    public Long createRoute(@Validated @RequestBody CreateRouteRequest request){
        return routesService.createRoute(request).getId();
    }

    @PutMapping(path = "/routes/{id}")
    public DtoRoutes updateRoute(@Validated @RequestBody DtoRoutes route, @PathVariable Long id){
        return routesService.updateRoute(route,id);
    }

    @GetMapping(path = "/routes/assign/{id}/{userId}")
    public int assignRoute(@PathVariable Long id, @PathVariable Long userId){
        return routesService.assignRoute(id, userId);
    }

    @GetMapping(path = "/routes/unassign/{id}")
    public int assignRoute(@PathVariable Long id){
        return routesService.unassignRoute(id);
    }

    @DeleteMapping(value = "/routes/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id){
        routesService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}
