package ar.com.pg22.test.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.pg22.test.messenger.model.Message;
import ar.com.pg22.test.messenger.resources.beans.MessagePageBean;
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
	private CommentResource commentResource;
	
	@Autowired
	private MessageService messageService;
	
	@GET
	public List<Message> getMessages(
			@QueryParam("year") int year){
		
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("paged")
	public List<Message> getMessagesPaged(@BeanParam MessagePageBean pageBean){
		if (pageBean.getPage() >= 0 && pageBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(pageBean.getPage(), pageBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo){
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
					.entity(newMessage)
					.build();
		
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
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return commentResource;
	}
}
