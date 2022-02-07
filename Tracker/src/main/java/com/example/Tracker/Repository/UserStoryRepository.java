package com.example.Tracker.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Tracker.Entity.UserStory;

@Repository
public interface UserStoryRepository extends MongoRepository<UserStory, String>{
	List<UserStory> findByEpicId(String id);
	void deleteAllByEpicId(String id);
	Optional<List<UserStory>> findByUserStoryOwner(String name);
	Optional<List<UserStory>> findByUserStoryAssigned(String name);
	Optional<List<UserStory>> findByUserStoryStatus(String Status);
	Optional<List<UserStory>> findByUserStoryOwnerAndUserStoryStatus(String name, String status);
	Optional<List<UserStory>> findByUserStoryOwnerAndUserStoryAssigned(String ownerName, String assignedName);
	Optional<List<UserStory>> findByUserStoryAssignedAndUserStoryStatus(String assignedName, String status);
	Optional<List<UserStory>> findByUserStoryOwnerAndUserStoryAssignedAndUserStoryStatus(String ownerName, String assignedName, String status);
}
