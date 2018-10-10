package com.events.access.model;

import lombok.Data;

@Data
public class Event {
	
	private String name;
	private String description;
	private String startTime;
	private String endTime;
	private String timeZone;
	private boolean isFree;
	private String location;
	private String url;
	

}
