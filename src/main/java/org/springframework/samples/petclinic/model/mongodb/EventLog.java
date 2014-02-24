package org.springframework.samples.petclinic.model.mongodb;

import java.util.Date;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="eventLog")
public class EventLog extends AbstractDocument {

	private String eventName;
	private String userName;
	private Date date;
	
	@PersistenceConstructor
	public EventLog(String e, String user, Date d){
		this.eventName = e;
		this.userName = user;
		this.date = d;
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
