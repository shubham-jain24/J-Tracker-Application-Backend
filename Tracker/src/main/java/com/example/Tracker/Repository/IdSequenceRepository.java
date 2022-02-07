package com.example.Tracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Tracker.Entity.IdSequence;

public interface IdSequenceRepository extends MongoRepository<IdSequence, String>{

}
