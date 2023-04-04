package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.domain.DtoComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<DtoComment, Long> {
    List<DtoComment> findAllByForumId(Long forumId);
}
