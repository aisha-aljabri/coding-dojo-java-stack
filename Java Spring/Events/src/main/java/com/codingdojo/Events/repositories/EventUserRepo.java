package com.codingdojo.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Events.models.Event;
import com.codingdojo.Events.models.EventUser;
import com.codingdojo.Events.models.User;

@Repository
public interface EventUserRepo extends CrudRepository<EventUser, Long>{
	EventUser findByEventAndUser(Event event, User user);
}
