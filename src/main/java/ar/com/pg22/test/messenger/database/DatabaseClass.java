package ar.com.pg22.test.messenger.database;

import java.util.HashMap;
import java.util.Map;

import ar.com.pg22.test.messenger.model.Message;
import ar.com.pg22.test.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
}
