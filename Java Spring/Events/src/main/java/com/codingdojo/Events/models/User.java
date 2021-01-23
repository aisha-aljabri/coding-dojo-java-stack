package com.codingdojo.Events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank(message="First Name is required")
	@Size(min=2, message="First name must be 2 characters or more")
	private String firstName;
	
	@NotBlank(message="Last Name is required")
	@Size(min=2, message="Last name must be 2 characters or more")
	private String lastName;
	
	@NotBlank(message="Email is required")
    @Email(message="Email must be in valid format (ex. name@host.com)")
    private String email;
    
    private String state;
	
	@NotBlank(message="City is required")
	@Size(min=2,message="City must be 2 characters or more")
	private String city;
	
	@NotBlank(message="password is required")
    @Size(min=5, message="Password must have more than 5 characters")
    private String password;
    
	@NotBlank(message="password Confirmation is required")
    @Transient
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Event> events;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments;
    
    
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="eventuser",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="event_id")
	)
    private List<Event> joindEvents;
    
    public User() {
    }
    
    

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
     
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


    public void setEvents(List<Event> events) {
    	this.events=events;
    }
    public List<Event> getEvents(){
    	return events;
    }
	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public List<Comment> getcomments() {
		return comments;
	}

	public void setcomments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	public List<Event> getjoindEvents() {
		return joindEvents;
	}

	public void setjoindEvents(List<Event> joindEvents) {
		this.joindEvents = joindEvents;
	}
	
}
