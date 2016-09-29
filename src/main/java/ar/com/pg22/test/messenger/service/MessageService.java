package ar.com.pg22.test.messenger.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.pg22.test.messenger.database.MessageDao;
import ar.com.pg22.test.messenger.model.Message;

public class MessageService {
	
	final static Logger logger = LogManager.getLogger(MessageService.class);
	
	@Autowired
	private MessageDao messageDao;
	
	//private Map<Long, Message> messages;
	
	public MessageService() {
		logger.debug("Initialising MessageService - Start.");
//		this.messages = database.getMessages();
//		
//		if (messages.isEmpty()) {
//			logger.debug("Adding dummy messages.");
//			messages.put(1L, new Message(1, "Hello World", "koushik"));
//			messages.put(2L, new Message(2, "Hello Jersey", "koushik"));
//		}
		
		logger.debug("Initialising MessageService - End.");
	}
	
	public List<Message> getAllMessages() {
		logger.debug("Getting all messages.");
		return messageDao.getAllMessages();
		//return new ArrayList<Message>(messages.values()); 
	}
	
	public Message getMessage(long id) {
		logger.debug("Geting message id {}.", id);
		return messageDao.getMessage(id);
		//Message message = messages.get(id);
		//return message;
	}
	
	public Message addMessage(Message message) {
		// TODO handle sequence ids
		logger.debug("Adding new message from author {}.", message.getAuthor());
		//message.setId(messages.size() + 1);
		logger.debug("New message id is {}", message.getId());
		//messages.put(message.getId(), message);
		Message newMessage = messageDao.saveMessage(message);
		logger.debug("Messages addition finished.");
		return newMessage;
	}
	
	public Message updateMessage(Message message) {
		logger.debug("Updating message id {}.", message.getId());
		if (message.getId() <= 0) {
			return null;
		}
//		messages.put(message.getId(), message);
		// TODO This is an upsert, it does not check if the object already exists
		Message updatedMessage = messageDao.saveMessage(message);
		return updatedMessage;
	}
	
	public Message removeMessage(long id) {
		logger.debug("Removing message id {}.", id);
		Message oldMessage = getMessage(id);
		messageDao.removeMessage(id);
		return oldMessage;
		//return messages.remove(id);
	}
}
