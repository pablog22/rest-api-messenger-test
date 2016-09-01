package ar.com.pg22.test.messenger.service;

import java.util.ArrayList;
import java.util.List;

import ar.com.pg22.test.messenger.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		List<Message> list = new ArrayList<>();
		list.add(new Message(1L, "Hello World", "koushik"));
		list.add(new Message(2L, "Hello Jersey", "koushik"));
		return list;
	}
}
