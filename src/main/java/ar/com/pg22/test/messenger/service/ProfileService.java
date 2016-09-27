package ar.com.pg22.test.messenger.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.pg22.test.messenger.database.ProfileDao;
import ar.com.pg22.test.messenger.model.Profile;

public class ProfileService {
	
	final static Logger logger = LogManager.getLogger(ProfileService.class);
	
	@Autowired
	private ProfileDao profileDao;
	
	public ProfileService() {
		logger.debug("Initialising ProfileService - Start.");
//		this.profiles = database.getProfiles();
//		if (profiles.isEmpty()) {
//			logger.debug("Adding dummy profiles.");
//			profiles.put("koushik", new Profile(1L, "koushik", "Koushik", "Kothagal"));
//		}
		logger.debug("Initialising ProfileService - End.");
	}
	
	public List<Profile> getAllProfiles() {
		logger.debug("Getting all profiles.");
		return profileDao.getAllProfiles();
	}
	
	public Profile getProfile(String profileName) {
		logger.debug("Geting profile with name {}.", profileName);
		return profileDao.getProfile(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		logger.debug("Adding new profile with name {}.", profile.getProfileName());
//		profile.setId(profiles.size() + 1);
//		logger.debug("New message id is {}", profile.getId());
		Profile newProfile = profileDao.saveProfile(profile);
		logger.debug("Profile addition finished.");
		return newProfile;
	}
	
	public Profile updateProfile(Profile profile) {
		logger.debug("Updating profile with name {}.", profile.getProfileName());
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		// TODO This is an upsert, it does not check if the object already exists
		Profile updatedProfile = profileDao.saveProfile(profile);
		return updatedProfile;
	}
	
	public Profile removeProfile(String profileName) {
		logger.debug("Removing profile with name {}.", profileName);
		Profile oldProfile = profileDao.getProfile(profileName);
		profileDao.removeProfile(profileName);
		return oldProfile;
	}
}
