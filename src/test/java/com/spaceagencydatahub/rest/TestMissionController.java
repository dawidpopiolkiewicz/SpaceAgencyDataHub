package com.spaceagencydatahub.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceagencydatahub.entity.ImageryType;
import com.spaceagencydatahub.entity.Mission;
import com.spaceagencydatahub.service.MissionService;

public class TestMissionController {

	private static Logger logger = Logger.getLogger(TestProductController.class.getName());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			logger.info(description.getMethodName() + " " + "started");
		}

		@Override
		protected void succeeded(Description description) {
			logger.info(description.getMethodName() + " " + "success");
		}

		@Override
		protected void failed(Throwable e, Description description) {
			logger.warning(description.getMethodName() + " "+"FAILED!" + " " + e.getMessage());
		}

		@Override
		protected void finished(Description description) {
			logger.info(description.getMethodName() + " " + "completed");
		}

	};

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

	@Test
	public void testAddMission() throws Exception {
		OffsetDateTime offSetDateTime = OffsetDateTime.now();
		ObjectMapper objectMapper = new ObjectMapper();

		Mission mission = new Mission();

		mission.setImageryType(ImageryType.Hyperspectral);
		mission.setName("mission1");
		mission.setStartDate(offSetDateTime);
		mission.setFinishDate(offSetDateTime);

		this.mockMvc.perform(post("/api/missions").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(mission)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteMission() throws Exception {
		this.mockMvc.perform(delete("/api/missions/{missionId}", 1))
		.andExpect(status().isOk());
	}
	

}
