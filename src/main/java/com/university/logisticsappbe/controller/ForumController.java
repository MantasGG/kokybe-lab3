package com.university.logisticsappbe.controller;

import com.university.logisticsappbe.model.api.CreateForumRequest;
import com.university.logisticsappbe.model.domain.DtoForum;
import com.university.logisticsappbe.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class ForumController {
    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping(path = "/forum")
    public List<DtoForum> fetchComments(){
        return forumService.fetchForum();
    }

    @PostMapping(path = "/forum")
    public DtoForum createForum(@Validated @RequestBody CreateForumRequest request){
        return forumService.createForum(request);
    }

    @PutMapping(path = "/forum/{id}")
    public DtoForum updateComment(@PathVariable DtoForum forum, Long id){
        return forumService.updateForum(forum, id);
    }

    @DeleteMapping(value = "/forum/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        forumService.deleteForum(id);
        return ResponseEntity.noContent().build();
    }
}
