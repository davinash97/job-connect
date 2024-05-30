package com.portal.jobconnect.service;

import com.portal.jobconnect.enums.Gender;
import com.portal.jobconnect.enums.Role;
import com.portal.jobconnect.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProfileService {

	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);
	Profile profile;
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

	public boolean updateProfile(String profileId, String name, String gender, String role, String email,
								 Long phone, Integer numOfPosts, Long numOfApplicants, String organizationName) {

		if (!profileMap.containsKey(profileId))
			return false;

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
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	public boolean deleteProfile(String profileId) {
		if (!profileMap.containsKey(profileId))
			return false;
		profileMap.remove(profileId);
		return true;
	}
}
