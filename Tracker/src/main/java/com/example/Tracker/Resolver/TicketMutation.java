package com.example.Tracker.Resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tracker.Entity.Result;
import com.example.Tracker.Entity.Ticket;
import com.example.Tracker.Service.TicketService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class TicketMutation implements GraphQLMutationResolver{
	
	@Autowired
	TicketService serv;
	
	public Result addTicket(String ticketType, String ticketDescription, String ticketOwner, String ticketTitle, 
			String ticketCreationDate, String ticketTargetCompletionDate, String ticketCompletionDate) {
		Ticket t = new Ticket();
		t.setTicketType(ticketType);
		t.setTicketDescription(ticketDescription);
		t.setTicketOwner(ticketOwner);
		t.setTicketCompletionDate(ticketCompletionDate);
		t.setTicketCreationDate(ticketCreationDate);
		t.setTicketTargetCompletionDate(ticketTargetCompletionDate);
		t.setTicketTitle(ticketTitle);
		return serv.saveTicket(t);
	}
	
	public Result updateTicket(String ticketId, String ticketType, String ticketDescription, String ticketOwner, String ticketTitle, 
			String ticketCreationDate, String ticketTargetCompletionDate, String ticketCompletionDate) {
		Ticket t = new Ticket();
		t.setTicketId(ticketId);
		t.setTicketType(ticketType);
		t.setTicketDescription(ticketDescription);
		t.setTicketOwner(ticketOwner);
		t.setTicketCompletionDate(ticketCompletionDate);
		t.setTicketCreationDate(ticketCreationDate);
		t.setTicketTargetCompletionDate(ticketTargetCompletionDate);
		t.setTicketTitle(ticketTitle);
		return serv.updateTicketData(t);
	}
	
	public Result deleteTicketById(String ticketId) {
		return serv.deleteTicketById(ticketId);
	}

}
