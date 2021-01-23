package com.codingdojo.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Events.models.Comment;
@Repository
public interface CommentRepo extends CrudRepository<Comment,Long>{

}
