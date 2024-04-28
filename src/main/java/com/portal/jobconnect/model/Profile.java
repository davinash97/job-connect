package com.portal.jobconnect.model;

import org.springframework.stereotype.Component;

import com.portal.jobconnect.enums.Gender;
import com.portal.jobconnect.enums.Role;

@Component
public class Profile {

	// Common
	private String id;
	private String name;
	private Gender gender = Gender.UNDEFINED;
	private Role role = Role.SEEKER;
	private String email;
	private Long phone;

	// Employee
	private Long savedJobs;
	private Integer experience;
	private Long appliedJobs;
	private String expertise;

	// Employer
	private Integer numOfPosts;
	private Long numOfApplicants;
	private String organizationName;

	// Common
	public Profile(String id, String name, Gender gender, Role role, String email, Long phone) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getSavedJobs() {
		return savedJobs;
	}

	public void setSavedJobs(Long savedJobs) {
		this.savedJobs = savedJobs;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Long getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Long appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Integer getNumOfPosts() {
		return numOfPosts;
	}

	public void setNumOfPosts(Integer numOfPosts) {
		this.numOfPosts = numOfPosts;
	}

	public Long getNumOfApplicants() {
		return numOfApplicants;
	}

	public void setNumOfApplicants(Long numOfApplicants) {
		this.numOfApplicants = numOfApplicants;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}