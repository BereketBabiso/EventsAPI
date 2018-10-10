package com.events.access.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.events.access.model.RestRoom;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import net.minidev.json.JSONArray;

@Service("restRoomService")
public class IRestRoomService implements RestRoomService {
	
	@Autowired
	RestTemplate restTemplate;	

	private static final String urlTemp ="https://www.refugerestrooms.org:443/api/v1/restrooms/by_location.json?unisex=true&";
	//lat=42.0408611&lng=-87.6801102";
	
	
	
	public List<RestRoom> findTheClosest(float lat, float lng, double range){
		
		String url = urlTemp+"lat="+lat+"&lng="+lng;
		ResponseEntity<String> restEntity = this.restTemplate.getForEntity(url, String.class);
		String jRestRoom = restEntity.getBody();
		//System.out.println(jRestRoom);
		//String s = jRestRoom.substring(1, jRestRoom.length()-1);
		
		//System.out.println(s);
		
		ReadContext readContext = JsonPath.parse(jRestRoom);
		
		JSONArray o = readContext.read("$.[*]");
        Iterator it = o.iterator();
        
        String name;
        String strt;
        double lt;
        double lg;
        
        List<RestRoom> listOfClosestRestRoom = new ArrayList<>();
        
        //This is the defualt value of distance ----> needs to be changed 
        double distance=0.4;
        
        while(it.hasNext()) {
        	 LinkedHashMap ja = (LinkedHashMap) it.next();
        	 Object key;
             key = ja.get("name");
             System.out.println("the name is "+key.toString());
             
             name = key.toString();
             
             key = ja.get("street");
             strt = key.toString();
             
             key = ja.get("latitude");
             System.out.println(("the lat is "+key));
             System.out.println("the class type " +key.getClass());
             lt = (double) key;
             
             lg = (double) ja.get("longitude");
             System.out.println(("lt="+lt+" and lg="+lg));
             
             
             key = ja.get("distance");
             System.out.println("the class type of distance is "+key.getClass());
            
             //uncomment the below line and try again --- > there was casting issue while reading the data
            // double dist = ((Double) key).doubleValue();
             
             
             if(distance<=range) {
            	 
             //Create the RestRoom 
            	 RestRoom rstRoom = new RestRoom();
            	 rstRoom.setName(name);
            	 rstRoom.setStreet(strt);
            	 rstRoom.setLat(lt);
            	 rstRoom.setLng(lg);
            	 
            	 listOfClosestRestRoom.add(rstRoom);
            	 
             }            
             
        }
		
		
		return listOfClosestRestRoom;
	}

}
