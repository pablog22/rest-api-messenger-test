package ar.com.pg22.test.messenger.model;

import static ar.com.pg22.test.messenger.util.DateUtil.getNewDate;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "profiles")
public class Profile {

	@Id
    private String profileName;
	
    private String firstName;
    
    private String lastName;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date created;
    
    public Profile() {
    	super();
    	this.created = getNewDate();
    }

	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
    
    
}
