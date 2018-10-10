package com.events.access.service;

import java.util.List;

import com.events.access.model.RestRoom;

public interface RestRoomService {
	
	public List<RestRoom> findTheClosest(float lat,float lng,double range);

}
