package com.portal.jobconnect.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.portal.jobconnect.enums.Gender;
import com.portal.jobconnect.enums.Role;
import com.portal.jobconnect.model.Profile;

@Component
public class ProfileService {

	Profile profile;

	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

	HashMap<String, Object> profileMap = new HashMap<>();

	public ProfileService() {
	}

	public boolean createProfile(String profileId, String name, String gender, String role, String email, Long phone) {
		if (profileMap.containsKey(profileId))
			return false;
		Role roleEnum = Role.valueOf(role.toUpperCase());
		Gender genderEnum = Gender.valueOf(gender.toUpperCase());
		profile = new Profile(profileId, name, genderEnum, roleEnum, email, phone);
		profileMap.put(profileId, profile);
		return true;
	}

	public Profile readProfile(String profileId) {
		if (!profileMap.containsKey(profileId))
			return null;

		return (Profile) profileMap.get(profileId);
	}

	public void updateProfile(String profileId, String name, String gender, String role, String email,
							  Long phone, Integer numOfPosts, Long numOfApplicants, String organizationName) {

		if (!profileMap.containsKey(profileId))
			return;

		try {
			Profile existingProfile = readProfile(profileId);

			if (name != null)
				existingProfile.setName(name);

			if (gender != null) {
				Gender genderEnum = Gender.valueOf(gender.toUpperCase());
				existingProfile.setGender(genderEnum);
			}

			if (role != null) {
				Role roleEnum = Role.valueOf(role.toUpperCase());
				existingProfile.setRole(roleEnum);
			}

			if (email != null)
				existingProfile.setEmail(email);

			if (phone != 0)
				existingProfile.setPhone(phone);

			if (numOfPosts != 0)
				existingProfile.setNumOfPosts(numOfPosts);

			if (numOfApplicants != 0)
				existingProfile.setNumOfApplicants(numOfApplicants);

			if (organizationName != null)
				existingProfile.setOrganizationName(organizationName);

			profileMap.put(profileId, existingProfile);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public boolean deleteProfile(String profileId) {
		if (!profileMap.containsKey(profileId))
			return false;
		profileMap.remove(profileId);
		return true;
	}
}
