package ar.com.pg22.test.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ar.com.pg22.test.messenger.database.DatabaseClass;
import ar.com.pg22.test.messenger.model.Message;

public class MessageService {
	
	final static Logger logger = LogManager.getLogger(MessageService.class);
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		logger.debug("Calling MessageService constructor.");
		if (messages.isEmpty()) {
			logger.debug("Adding dummy messages.");
			messages.put(1L, new Message(1, "Hello World", "koushik"));
			messages.put(2L, new Message(2, "Hello Jersey", "koushik"));
		}
	}
	
	public List<Message> getAllMessages() {
		logger.debug("Getting all messages.");
		return new ArrayList<Message>(messages.values()); 
	}
	
	public Message getMessage(long id) {
		logger.debug("Geting message id {}.", id);
		Message message = messages.get(id);
		return message;
	}
	
	public Message addMessage(Message message) {
		logger.debug("Adding new message from author {}.", message.getAuthor());
		message.setId(messages.size() + 1);
		logger.debug("New message id is {}", message.getId());
		messages.put(message.getId(), message);
		logger.debug("Messages addition finished.");
		return message;
	}
	
	public Message updateMessage(Message message) {
		logger.debug("Updating message id {}.", message.getId());
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		logger.debug("Removing message id {}.", id);
		return messages.remove(id);
	}
}
