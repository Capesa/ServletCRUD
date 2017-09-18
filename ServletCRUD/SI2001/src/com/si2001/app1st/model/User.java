package com.si2001.app1st.model;


import java.util.List;

import javax.persistence.*;

@Entity
@Table( name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="user_id", nullable=false, unique=true)
	private int id;
	
	@Column(name="first_name", length=40, nullable=false)
	private String firstname;
	
	@Column(name="last_name", length=40, nullable=false)
	private String lastname;
	
 	@ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatus;
 	
 	@ManyToMany(fetch = FetchType.EAGER)
 	 @JoinTable(
         name = "user_skills", 
         joinColumns = { @JoinColumn(name = "user_id") }, 
         inverseJoinColumns = { @JoinColumn(name = "skill_id") }
     )
 	
 	 private List<Skill> skills;
 	
 	public User() {}

	public User(String fn, String ln) {
		
		firstname = fn;
		lastname  = ln;
		
			
	}

		public User(String fn, String ln, int mid) {
		
		firstname = fn;
		lastname  = ln;
		
		
			
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		

	 public MaritalStatus getMaritalStatus(){
	        return this.maritalStatus;
	    }

	public void setMaritalStatus(MaritalStatus maritalStatus){
	        this.maritalStatus = maritalStatus;
	 }

	public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
	
}