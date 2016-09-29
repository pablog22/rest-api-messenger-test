package ar.com.pg22.test.messenger.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import ar.com.pg22.test.messenger.database.repositories.ProfileRepository;
import ar.com.pg22.test.messenger.model.Profile;

public class ProfileDao {
	
	@Autowired
	private ProfileRepository repository;
	
	public List<Profile> getAllProfiles() {
		List<Profile> allProfiles = Lists.newArrayList(repository.findAll());
		return allProfiles;
	}
	
	public Profile getProfile(String profileName){
		return repository.findOne(profileName);
	}
	
	public Profile saveProfile(Profile profile) {
		return repository.save(profile);
	}
	
	public void removeProfile(String profileName) {
		repository.delete(profileName);
	}

}
