package com.example.Tracker.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tracker.Entity.IdSequence;
import com.example.Tracker.Entity.Result;
import com.example.Tracker.Entity.UserStory;
import com.example.Tracker.Repository.CommentRepository;
import com.example.Tracker.Repository.IdSequenceRepository;
import com.example.Tracker.Repository.UserStoryRepository;

@Service
public class UserStoryService {
	@Autowired
	UserStoryRepository repo;
	
	@Autowired
	IdSequenceRepository idRepo;
	
	@Autowired
	CommentRepository cRepo;
	
	public Result addUserStory(UserStory u) {
		int nextVal;
		Optional<IdSequence> idNumber = idRepo.findById("UserStory");
		if (idNumber.isPresent()) {
			u.setUserStoryId("UST"+ idNumber.get().getIdValue());
			nextVal = idNumber.get().getIdValue() + 1;
		}
		else {
			u.setUserStoryId("UST"+ "222");
			nextVal = 223;
		}
		IdSequence idObj = new IdSequence();
		idObj.setIdName("UserStory");
		idObj.setIdValue(nextVal);
		idRepo.save(idObj);
		repo.save(u);
		Result r = new Result();
		r.setStatusCode(200);
		r.setStatusMessage("User Story Created Successfully!");
		return r;
	}
	
	public Result updateUserStoryData(UserStory u) {
		repo.deleteById(u.getUserStoryId());
		repo.save(u);
		Result r = new Result();
		r.setStatusCode(200);
		r.setStatusMessage("User Story Updated Successfully!");
		return r;
	}
	
	public Result deleteById(String storyId) {
		cRepo.deleteAllBySourceId(storyId);
		repo.deleteById(storyId);
		Result r = new Result();
		r.setStatusCode(200);
		r.setStatusMessage("User Story Deleted Successfully!");
		return r;
	}
	
	public List<UserStory> findUserStoryByEpicId(String id){
		return repo.findByEpicId(id);
	}
	
	public List<UserStory> getUserStory(){
		return repo.findAll();
	}
	
	public Optional<UserStory> findUserStoryById(String id) {
		return repo.findById(id);
	}
	
	public Optional<List<UserStory>> findByUserStoryOwnerName(String ownerName){
		return repo.findByUserStoryOwner(ownerName);
	}
	
	public Optional<List<UserStory>> findByUserStoryAssigneeName(String assignedName){
		return repo.findByUserStoryAssigned(assignedName);
	}
	
	public Optional<List<UserStory>> findByUserStoryStatus(String status){
		return repo.findByUserStoryStatus(status);
	}
	
	public Optional<List<UserStory>> findByUserStoryOwnerAndStatus(String name, String status){
		return repo.findByUserStoryOwnerAndUserStoryStatus(name, status);
	}
	
	public Optional<List<UserStory>> findByUserStoryAssignedAndStatus(String assignedName, String status){
		return repo.findByUserStoryAssignedAndUserStoryStatus(assignedName, status);
	}
	
	public Optional<List<UserStory>> findByUserStoryOwnerAndAssigned(String ownerName, String assignedName){
		return repo.findByUserStoryOwnerAndUserStoryAssigned(ownerName, assignedName);
	}
	
	public Optional<List<UserStory>> findByUserStoryOwnerAndStatusAndAssigned(String ownerName, String assignedName, String status){
		return repo.findByUserStoryOwnerAndUserStoryAssignedAndUserStoryStatus(ownerName, assignedName, status);
	}
	
}
