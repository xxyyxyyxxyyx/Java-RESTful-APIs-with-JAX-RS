package org.sunil.limbu.messenger.service;

import java.util.*;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.sunil.limbu.messenger.database.DatabaseClass;
import org.sunil.limbu.messenger.model.Message;
@Path("/messages")
public class MessageService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1,"Hello World","Sunil"));
		messages.put(2L, new Message(2,"Hello Earth","Nilsu"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>( messages.values());
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0)return null;
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
}
