package ar.com.pg22.test.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.pg22.test.messenger.model.Message;
import ar.com.pg22.test.messenger.service.MessageService;

@Component
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	final static Logger logger = LogManager.getLogger(MessageResource.class);
	
	public MessageResource(){
		logger.debug("Initialising MessageResource.");
	}
	
	@Autowired
	private MessageService messageService;
	
	@GET
	public List<Message> getMessages(
			@QueryParam("year") int year,
			@QueryParam("page") int page,
			@QueryParam("size") int size){
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (page >= 0 && size > 0) {
			return messageService.getAllMessagesPaginated(page, size);
		}
		
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void updateMessage(@PathParam("messageId") long id){
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") long id){
		return messageService.getMessage(id);
	}
}
