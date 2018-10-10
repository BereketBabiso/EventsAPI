package com.events.access.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.events.access.model.Event;
import com.events.access.service.EventService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@GetMapping("/home")
	public String home() {
		return "hello";
	}
	
	 @ApiOperation(value="Get list of events in your search city")
	@GetMapping(value="/events",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Event> getEvents(@RequestParam("city") String city){
				
		return this.eventService.searchEventsByCity(city);
	}

}
