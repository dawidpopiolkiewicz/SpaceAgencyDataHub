package com.spaceagencydatahub.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class TestDemoController {

	@InjectMocks
	private DemoController demoController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
	}
	
	@Test
	public void testWorkingDemoController() throws Exception{
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk());
	}
	
	
	
	
	
	
	

}
