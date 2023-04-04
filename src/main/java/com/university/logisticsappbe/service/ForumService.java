package com.university.logisticsappbe.service;

import com.university.logisticsappbe.model.api.CreateForumRequest;
import com.university.logisticsappbe.model.domain.DtoForum;
import com.university.logisticsappbe.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {
    private final ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public List<DtoForum> fetchForum(){
        return forumRepository.findAll();
    }

    public DtoForum createForum(CreateForumRequest request){
        DtoForum forum = DtoForum.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .createdBy(request.getCreatedBy())
                .build();
        return forumRepository.save(forum);
    }

    public DtoForum updateForum(DtoForum forum, Long id){
        forum.setId(id);
        return forumRepository.save(forum);
    }

    public void deleteForum(Long id){
        forumRepository.deleteById(id);
    }
}
