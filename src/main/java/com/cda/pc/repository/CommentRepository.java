package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cda.pc.Models.Comment;


public interface CommentRepository extends  CrudRepository<Comment, Long>{

	
}
