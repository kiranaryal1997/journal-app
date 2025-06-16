package com.kiranaryal.journal_app.repository;

import com.kiranaryal.journal_app.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JournalRepository extends MongoRepository<Journal, ObjectId> {
}
