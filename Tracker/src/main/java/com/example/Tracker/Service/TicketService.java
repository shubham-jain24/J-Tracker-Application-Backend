package com.example.Tracker.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tracker.Entity.IdSequence;
import com.example.Tracker.Entity.Result;
import com.example.Tracker.Entity.Ticket;
import com.example.Tracker.Entity.UserStory;
import com.example.Tracker.Repository.CommentRepository;
import com.example.Tracker.Repository.IdSequenceRepository;
import com.example.Tracker.Repository.TicketRepository;
import com.example.Tracker.Repository.UserStoryRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository repo;
	@Autowired
	UserStoryRepository uRepo;
	@Autowired
	CommentRepository cRepo;
	
	@Autowired
	IdSequenceRepository idRepo;
	
	public Result saveTicket(Ticket t) {
		int nextVal;
		Optional<IdSequence> idNumber = idRepo.findById("Ticket");
		if (idNumber.isPresent()) {
			t.setTicketId("TKT"+ idNumber.get().getIdValue());
			nextVal = idNumber.get().getIdValue() + 1;
		}
		else {
			t.setTicketId("TKT"+ "111");
			nextVal = 112;
		}
		IdSequence idObj = new IdSequence();
		idObj.setIdName("Ticket");
		idObj.setIdValue(nextVal);
		idRepo.save(idObj);
		
		repo.save(t);
		Result r = new Result();
		r.setStatusCode(200);
		r.setStatusMessage("Ticket Created Successfully");
		return r;
	}
	
	public Result updateTicketData(Ticket t) {
		
		repo.deleteById(t.getTicketId());
		repo.save(t);
		
		Result r = new Result();
		r.setStatusCode(200);
		r.setStatusMessage("Ticket Created Successfully");
		return r;
	}
	
	public Result deleteTicketById(String ticketId) {
		List<UserStory> uList = uRepo.findByEpicId(ticketId);
		for (UserStory u : uList) {
			cRepo.deleteAllBySourceId(u.getUserStoryId());
			uRepo.deleteById(u.getUserStoryId());
		}
		
		cRepo.deleteAllBySourceId(ticketId);
		repo.deleteById(ticketId);
		Result r = new Result();
		r.setStatusCode(200);
		r.setStatusMessage("Ticket Created Successfully");
		return r;
	}
	
	public List<Ticket> findAllTicket(){
		return repo.findAll();
	}
	
	public Optional<Ticket> findTicketById(String id) {
		return repo.findById(id);
	}
}
