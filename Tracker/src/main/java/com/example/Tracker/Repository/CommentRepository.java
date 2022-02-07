package com.example.Tracker.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Tracker.Entity.Comments;

@Repository
public interface CommentRepository extends MongoRepository<Comments, String>{
	List<Comments> findBySourceId(String id);
	void deleteAllBySourceId(String id);
}
