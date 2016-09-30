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
	
	public MessageService() {
		logger.debug("Initialising MessageService - Start.");
		logger.debug("Initialising MessageService - End.");
	}
	
	public List<Message> getAllMessages() {
		logger.debug("Getting all messages.");
		return messageDao.getAllMessages();
		
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		logger.debug("Getting all messages for year {}.", year);
		return messageDao.getAllMessagesForYear(year);
		
	}
	
	public List<Message> getAllMessagesPaginated(int page, int size) {
		logger.debug("Getting all messages paginated for page: {} and size: {}.", page, size);
		return messageDao.getAllMessagesPaginated(page, size);
	}
	
	public Message getMessage(long id) {
		logger.debug("Geting message id {}.", id);
		return messageDao.getMessage(id);
	}
	
	public Message addMessage(Message message) {
		logger.debug("Adding new message from author {}.", message.getAuthor());
		message.setId(messageDao.getNewMessageId());
		logger.debug("New message id is {}", message.getId());
		Message newMessage = messageDao.saveMessage(message);
		logger.debug("Messages addition finished.");
		return newMessage;
	}
	
	public Message updateMessage(Message message) {
		logger.debug("Updating message id {}.", message.getId());
		if (message.getId() <= 0) {
			return null;
		}

		// TODO This is an upsert, it does not check if the object already exists
		Message updatedMessage = messageDao.saveMessage(message);
		return updatedMessage;
	}
	
	public Message removeMessage(long id) {
		logger.debug("Removing message id {}.", id);
		Message oldMessage = getMessage(id);
		messageDao.removeMessage(id);
		return oldMessage;
	}
}
