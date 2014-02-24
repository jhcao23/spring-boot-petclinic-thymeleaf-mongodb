package org.springframework.samples.petclinic.repository.springdatamongodb;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.samples.petclinic.model.mongodb.EventLog;


public interface EventLogRepository extends MongoRepository<EventLog, BigInteger> {

}
