package ar.com.pg22.test.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ar.com.pg22.test.messenger.model.Message;
import ar.com.pg22.test.messenger.model.Profile;

public class DatabaseClass {
	
	final static Logger logger = LogManager.getLogger(DatabaseClass.class);

	private Map<Long, Message> messages = new HashMap<>();
	private Map<String, Profile> profiles = new HashMap<>();
	
	public DatabaseClass(){
		logger.debug("Initialising DatabaseClass.");
	}

	
	public Map<Long, Message> getMessages() {
		return messages;
	}
	
	public Map<String, Profile> getProfiles() {
		return profiles;
	}
	
}
