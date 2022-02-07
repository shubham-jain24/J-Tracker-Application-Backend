package com.example.Tracker.Resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tracker.Entity.Result;
import com.example.Tracker.Entity.UserStory;
import com.example.Tracker.Service.UserStoryService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class UserStoryMutation implements GraphQLMutationResolver {
	@Autowired
	UserStoryService serv;

	public Result addUserStory(String epicId, String userStoryTitle, String userStoryDescription, String userStoryAcceptanceCriteria,
			String userStoryOwner, String userStoryAssigned, String userStoryStatus, Integer userStoryEffort,
			String userStoryStartDate, String userStoryCompletionDate, String userStoryExpectedCompletionDate,
			Integer userStoryCompletedEffort, Integer userStoryRemainingEffort) {
		
		UserStory u = new UserStory();
		u.setEpicId(epicId);
		u.setUserStoryAcceptanceCriteria(userStoryAcceptanceCriteria);
		u.setUserStoryAssigned(userStoryAssigned);
		u.setUserStoryCompletedEffort(userStoryCompletedEffort);
		u.setUserStoryCompletionDate(userStoryCompletionDate);
		u.setUserStoryDescription(userStoryDescription);
		u.setUserStoryEffort(userStoryEffort);
		u.setUserStoryExpectedCompletionDate(userStoryExpectedCompletionDate);
		u.setUserStoryOwner(userStoryOwner);
		u.setUserStoryRemainingEffort(userStoryRemainingEffort);
		u.setUserStoryStartDate(userStoryStartDate);
		u.setUserStoryStatus(userStoryStatus);
		u.setUserStoryTitle(userStoryTitle);
		return serv.addUserStory(u);	
	}
	
	public Result updateUserStory(String userStoryId, String epicId, String userStoryTitle, String userStoryDescription, String userStoryAcceptanceCriteria,
				String userStoryOwner, String userStoryAssigned, String userStoryStatus, Integer userStoryEffort,
				String userStoryStartDate, String userStoryCompletionDate, String userStoryExpectedCompletionDate,
				Integer userStoryCompletedEffort, Integer userStoryRemainingEffort) {
			
			UserStory u = new UserStory();
			u.setUserStoryId(userStoryId);
			u.setEpicId(epicId);
			u.setUserStoryAcceptanceCriteria(userStoryAcceptanceCriteria);
			u.setUserStoryAssigned(userStoryAssigned);
			u.setUserStoryCompletedEffort(userStoryCompletedEffort);
			u.setUserStoryCompletionDate(userStoryCompletionDate);
			u.setUserStoryDescription(userStoryDescription);
			u.setUserStoryEffort(userStoryEffort);
			u.setUserStoryExpectedCompletionDate(userStoryExpectedCompletionDate);
			u.setUserStoryOwner(userStoryOwner);
			u.setUserStoryRemainingEffort(userStoryRemainingEffort);
			u.setUserStoryStartDate(userStoryStartDate);
			u.setUserStoryStatus(userStoryStatus);
			u.setUserStoryTitle(userStoryTitle);
			return serv.updateUserStoryData(u);	
		}
	
	
	public Result deleteUserStory(String userStoryId) {
		return serv.deleteById(userStoryId);
	}
	

}
