package com.si2001.app1st.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

import javax.persistence.Table;

@Entity
@Table( name = "skills")

public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id", nullable=false, unique=true)
	private int skillId;
	
	@Column(name = "skill", length = 45, nullable = false)
	private String skill;
	
		
	public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String name) {
        this.skill = name;
    }

}
