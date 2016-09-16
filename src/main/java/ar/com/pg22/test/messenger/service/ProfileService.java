package ar.com.pg22.test.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ar.com.pg22.test.messenger.database.DatabaseClass;
import ar.com.pg22.test.messenger.model.Profile;

public class ProfileService {
	
	final static Logger logger = LogManager.getLogger(ProfileService.class);
		
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		logger.debug("Calling ProfileService constructor.");
		if (profiles.isEmpty()) {
			logger.debug("Adding dummy profiles.");
			profiles.put("koushik", new Profile(1L, "koushik", "Koushik", "Kothagal"));
		}
	}
	
	public List<Profile> getAllProfiles() {
		logger.debug("Getting all profiles.");
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		logger.debug("Geting profile with name {}.", profileName);
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		logger.debug("Adding new profile with name {}.", profile.getProfileName());
		profile.setId(profiles.size() + 1);
		logger.debug("New message id is {}", profile.getId());
		profiles.put(profile.getProfileName(), profile);
		logger.debug("Profile addition finished.");
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		logger.debug("Updating profile with name {}.", profile.getProfileName());
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		logger.debug("Removing profile with name {}.", profileName);
		return profiles.remove(profileName);
	}
}
