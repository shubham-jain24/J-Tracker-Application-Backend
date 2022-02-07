package com.example.Tracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tracker.Entity.Comments;
import com.example.Tracker.Repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository repo;
	public String addComment(Comments c) {
		repo.save(c);
		return "Comment Added Successfully";
	}
	
	public List<Comments> getAllCommennts(String id){
		return repo.findBySourceId(id);
	}

}
