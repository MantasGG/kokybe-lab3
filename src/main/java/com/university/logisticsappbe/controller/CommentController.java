package com.university.logisticsappbe.controller;

import com.university.logisticsappbe.model.api.CreateCommentRequest;
import com.university.logisticsappbe.model.domain.DtoComment;
import com.university.logisticsappbe.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/comments")
    public List<DtoComment> fetchComments(){
        return commentService.fetchComments();
    }

    @GetMapping(path = "/comments/{forumId}")
    public List<DtoComment> fetchCommentsByForumId(@PathVariable Long forumId){
        return commentService.fetchCommentsByForumId(forumId);
    }

    @PostMapping(path = "/comments")
    public Long createComment(@Validated @RequestBody CreateCommentRequest request){
        return  commentService.createComment(request).getId();
    }

    @PutMapping(path = "/comments/{id}")
    public DtoComment updateComment(@PathVariable DtoComment comment, Long id){
        return commentService.updateComment(comment, id);
    }

    @DeleteMapping(value = "/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
