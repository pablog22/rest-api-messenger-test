package ar.com.pg22.test.messenger.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import ar.com.pg22.test.messenger.database.repositories.MessageRepository;
import ar.com.pg22.test.messenger.model.Message;

public class MessageDao {
	
	@Autowired
	private MessageRepository repository;
	
	public List<Message> getAllMessages(){
		List<Message> allMessages = Lists.newArrayList(repository.findAll());
		return allMessages;
	}
	
	public Message getMessage(long id) {
		return repository.findOne(id);
	}
	
	public Message saveMessage(Message message){
		return repository.save(message);
	}
	
	public void removeMessage(long id) {
		repository.delete(id);
	}

}
