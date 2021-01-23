package com.codingdojo.Events.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.Events.models.Comment;
import com.codingdojo.Events.models.Event;
import com.codingdojo.Events.models.EventUser;
import com.codingdojo.Events.models.User;
import com.codingdojo.Events.repositories.CommentRepo;
import com.codingdojo.Events.repositories.EventRepo;
import com.codingdojo.Events.repositories.EventUserRepo;
import com.codingdojo.Events.repositories.UserRepository;

@Service
public class AppService {
private final UserRepository userRepository;
private final EventRepo eventRepo;
private final CommentRepo commentRepo;
private final EventUserRepo eventuserRepo;

    
    public AppService(UserRepository userRepository, EventRepo eventRepo, CommentRepo commentRepo, EventUserRepo eventuserRepo) {
        this.userRepository = userRepository;
        this.eventRepo=eventRepo;
        this.commentRepo=commentRepo;
        this.eventuserRepo=eventuserRepo;
    }
    
    
//registration & login
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
    
 //Event
    public Event createEvent(Event event, Long id) {
		event.setUser(getUserById(id));
		return eventRepo.save(event);
	}
    
    public List<Event> sameState(String state){
		return eventRepo.findByStateContains(state);
	}
    
    public List<Event> anotherState(String state){
		return eventRepo.findByStateNotContains(state);
	}
    
    public Event findevent(Long id) {
		if(eventRepo.findById(id) != null) {
			return eventRepo.findById(id).get();
		}
		else {
			return null;
		}
	}
    
    public void deleteEvent(Long id) {
    	eventRepo.deleteById(id);
	}
	
	public void editEvent(Event event) {
		eventRepo.save(event);
	
	}
	
	public EventUser createEventUser(EventUser eventUser) {
		return eventuserRepo.save(eventUser);
	}
	
	public void cancel(EventUser eventUser) {
		eventuserRepo.delete(eventUser);
	}
	
	public Comment addComment(Comment comment) {
		return commentRepo.save(comment);
	}
	
	public Iterable<EventUser> joinedEvents() {
		return eventuserRepo.findAll();
	}
	
	public EventUser findEventUser(Event event, User user) {
		return eventuserRepo.findByEventAndUser(event, user);
	}

}
