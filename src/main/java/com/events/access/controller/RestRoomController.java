package com.events.access.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.events.access.model.RestRoom;
import com.events.access.service.RestRoomService;

@RestController
@RequestMapping("/api/rest")
public class RestRoomController {
	
	@Autowired
	RestRoomService restRoomService;
	
	
	@GetMapping("/closest")
	public List<RestRoom> getRestRooms(@RequestParam("lat") float lat, 
									   @RequestParam("long") float lng,
									   @RequestParam("range") double range){
		
		
		return this.restRoomService.findTheClosest(lat,lng,range);
		
		//return null;
	}

}
