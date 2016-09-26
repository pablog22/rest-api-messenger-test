package ar.com.pg22.test.messenger.model;

import static ar.com.pg22.test.messenger.util.DateUtil.getNewDate;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "messages")
public class Message {
	
	@Id
	private long id;
	
    private String message;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date created;
    
    private String author;
    
    public Message() {
    	super();
    	this.created = getNewDate();
    }
    
    public Message(long id, String message, String author) {
    	this();
		this.id = id;
		this.message = message;
		this.created = getNewDate();
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
    
}
