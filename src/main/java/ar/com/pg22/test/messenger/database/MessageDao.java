package ar.com.pg22.test.messenger.database;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.google.common.collect.Lists;

import ar.com.pg22.test.messenger.database.repositories.MessageRepository;
import ar.com.pg22.test.messenger.model.Message;
import ar.com.pg22.test.messenger.util.DateUtil;

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
	
	public List<Message> getAllMessagesForYear(int year) {
		Date startDate = DateUtil.getFirstDayOfYear(year);
		Date endDate = DateUtil.getFirstDayOfYear(year + 1);
		return mongoOps.find(query(where("created").gte(startDate).lt(endDate)), Message.class);
	}
	
	public List<Message> getAllMessagesPaginated(int page, int size) {
		Page<Message> result = repository.findAll(new PageRequest(page, size));
		return result.getContent();
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
