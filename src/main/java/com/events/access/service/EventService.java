package com.events.access.service;

import java.util.List;

import com.events.access.model.Event;

public interface EventService {
	
	public List<Event> searchEventsByCity(String city);

}
