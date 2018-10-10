package com.events.access.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.events.access.model.Event;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import net.minidev.json.JSONArray;

@Service("eventService")
public class IEventService implements EventService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final String TOKEN="JDUHRQGB6JDXB3S2DZ6H";
	private static final String urlTemp ="https://www.eventbriteapi.com/v3/events/search/?token=JDUHRQGB6JDXB3S2DZ6H&location.address=";
	


	public List<Event> searchEventsByCity(String city) {
		List<Event> result = eventHelper(city);
		
		return result;
	}
	
	private List<Event> eventHelper(String city){
		
		String url = urlTemp+city;
		
		ResponseEntity<String> eventsEntity = this.restTemplate.getForEntity(url, String.class);
		String eventsJson = eventsEntity.getBody();
		ReadContext readContext = JsonPath.parse(eventsJson);
		JSONArray o = readContext.read("$.events[*]");
		Iterator it = o.iterator();
		
		List<Event> eventsList = new ArrayList<>();
		String eventName;
		String eventDescription;
		String eventStartTime;
		String eventEndTime;
		String eventTimeZone="local";
		boolean isFree;
		String eventLocation = city;
		String eventUrl;
		
		while(it.hasNext()) {
			 LinkedHashMap ja = (LinkedHashMap) it.next();			
			 Object key;
			 key= ja.get("name");
            
			 //get the name of the event
             String n = key.toString();
             String name = n.substring(1,n.length()-1);            
             String []names = name.split(", ");
             eventName = names[0].substring(5);
             System.out.println(eventName);
             
             //get start time
             key = ja.get("start");
             String st = key.toString();
             String stime = st.substring(1,st.length()-1);
             String[] sartTime= stime.split(", ");
             eventStartTime=sartTime[1].substring(6);
             System.out.println("start time "+eventStartTime);
             
             //get event end time
             key = ja.get("end");
             String et = key.toString();
             String etime = et.substring(1,et.length()-1);
             String[] endTime = etime.split(", ");
             eventEndTime = endTime[1].substring(6);
             System.out.println("end time "+eventStartTime);
             
             //get description of the event
             key= ja.get("description");
             String d = key.toString();
             String descrp = d.substring(1,d.length()-1);
             String edescps[] = descrp.split(", ");
             eventDescription=edescps[0];
             
             //is the event for free
             key= ja.get("is_free");
             String free=key.toString();
             System.out.println("is free "+free);
             if(free.equalsIgnoreCase("false")) isFree=false;
             else isFree=true;
            
             //get the event url
             key= ja.get("url");
             eventUrl=key.toString();
             
             //Create an event instance
             Event evt = new Event();
             evt.setName(eventName);
             evt.setStartTime(eventStartTime);
             evt.setEndTime(eventEndTime);
             evt.setDescription(eventDescription);
             evt.setLocation(eventLocation);
             evt.setFree(isFree);
             evt.setTimeZone(eventTimeZone);
             evt.setUrl(eventUrl);
             
             //add event to the list
             eventsList.add(evt);
             
             
             
//             ReadContext temp = JsonPath.parse(key.toString());
//             String x = temp.read("$.text");
            
             
		}
		 
		//System.out.println(o);
		
		//String eventName = readContext.read("$.events.[0].name.text");
		//String eventDescription = readContext.read(path)
		
		//System.out.println(eventName);
		
		return eventsList;
	}

}
