package com.university.logisticsappbe.service;

import com.university.logisticsappbe.model.api.CreateCommentRequest;
import com.university.logisticsappbe.model.domain.DtoComment;
import com.university.logisticsappbe.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<DtoComment> fetchComments(){
        return commentRepository.findAll();
    }

    public List<DtoComment> fetchCommentsByForumId(Long forumId){
        List<DtoComment> commentList = commentRepository.findAllByForumId(forumId);
        if(commentList.isEmpty()) {
            return null;
        }
        else {
            return commentRepository.findAllByForumId(forumId);
        }
    }

    public DtoComment createComment(CreateCommentRequest request){
        DtoComment comment = DtoComment.builder()
                .forumId(request.getForumId())
                .replyId(request.getReplyId())
                .comment(request.getComment())
                .createdBy(request.getCreatedBy())
                .build();
        return commentRepository.save(comment);
    }

    public DtoComment updateComment(DtoComment comment, Long id){
        comment.setId(id);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

}
