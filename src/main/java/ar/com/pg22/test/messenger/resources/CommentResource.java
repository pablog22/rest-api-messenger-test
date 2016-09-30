package ar.com.pg22.test.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	
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
