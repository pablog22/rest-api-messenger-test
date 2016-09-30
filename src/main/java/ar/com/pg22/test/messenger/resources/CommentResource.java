package ar.com.pg22.test.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class CommentResource {
	
	final static Logger logger = LogManager.getLogger(CommentResource.class);
	
	public CommentResource() {
		logger.debug("Initialising CommentResource.");
	}
	
	@GET
	public String getComments(@PathParam("messageId") long id){
		return "i will return all the comments";
	}
	
	@GET
	@Path("/{commentId}")
	public String getComment(
			@PathParam("messageId") long messageId, 
			@PathParam("commentId") long commentId){
		return "i will return the comment id " + commentId + "of the message id " + messageId;
	}

}
