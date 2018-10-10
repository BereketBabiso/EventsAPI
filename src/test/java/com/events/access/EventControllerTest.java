package com.events.access;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.events.access.controller.EventController;

@RunWith(SpringJUnit4ClassRunner.class)
public class EventControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private EventController eventController;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
		
	}
	
	@Test
	public void TestGetEvents() throws Exception {
		
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/events").accept(MediaType.APPLICATION_JSON_VALUE))
//			   .andExpect(MockMvcResultMatchers.status().isOk())
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(type)))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.description", matcher))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.startTime", matcher))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.endTime", matcher))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.timeZone", matcher))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.isFree", matcher))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.location", matcher))
//			   .andExpect(MockMvcResultMatchers.jsonPath("$.location", matcher))
			   
			   
		
		
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/events"))
//			   .andExpect(MockMvcResultMatchers.status().isOk())
//			   .andExpect(MockMvcResultMatchers.content().)
		
	}

}
