package com.example.Tracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Tracker.Entity.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>{

}
