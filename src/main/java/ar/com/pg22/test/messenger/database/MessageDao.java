package ar.com.pg22.test.messenger.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.google.common.collect.Lists;

import ar.com.pg22.test.messenger.database.repositories.MessageRepository;
import ar.com.pg22.test.messenger.model.Message;

public class MessageDao {
	
	@Autowired
	private MessageRepository repository;
	
	@Autowired
	private MongoOperations mongoOps;
	
	private static Sort sortByIdDesc = new Sort(Sort.Direction.DESC, "id");
	
	private static Query queryNewMessageId;
	
	static {
		queryNewMessageId = new Query().with(sortByIdDesc).limit(1);
	}
	
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
	
	/**
	 * The method must be used to get a new message id
	 * @return the highest message id plus one
	 */
	public long getNewMessageId(){
		Message hiestIdMessage = mongoOps.findOne(queryNewMessageId, Message.class);
		return hiestIdMessage.getId() + 1;
	}
	
	public void removeMessage(long id) {
		repository.delete(id);
	}

}
