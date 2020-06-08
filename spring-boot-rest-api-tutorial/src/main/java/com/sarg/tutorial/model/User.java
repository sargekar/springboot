package com.sarg.tutorial.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;
	
	private Long getId() {
		return id;
	}
	
	public String getFirstName(Long id) {
		return firstName;		
	}
	
	public String getLastName(Long id) {
		return lastName;		
	}
	
	public String getEmailAddress(Long id) {
		return emailAddress;		
	}
	
	public Date getCreatedAt(Long id) {
		return createdAt;		
	}
	
	public String getCreatedBy(Long id) {
		return createdBy;		
	}
	
	public Date getUpdatedAt(Long id) {
		return updatedAt;		
	}
	
	public String getUpdatedBy(Long id) {
		return updatedBy;		
	}

}
