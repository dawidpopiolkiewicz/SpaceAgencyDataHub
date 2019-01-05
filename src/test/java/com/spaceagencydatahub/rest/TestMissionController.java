package com.spaceagencydatahub.rest;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spaceagencydatahub.entity.Mission;
import com.spaceagencydatahub.service.MissionService;

public class TestMissionController {

	@InjectMocks
	private MissionController missionController;
	
	@Mock
	private MissionService missionService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(missionController).build();
	}
	
	public void testAddMission() throws Exception{
		
		Mission mission = new Mission();

		
		
		
		
	}
	
}
