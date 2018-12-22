package com.spaceagencydatahub.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spaceagencydatahub.entity.Mission;
import com.spaceagencydatahub.service.MissionService;

@RestController
@RequestMapping("/api")
public class MissionController {

	@Autowired
	private MissionService missionService;

	@PostMapping("/missions")
	public Mission addMission(@RequestBody Mission mission) {
		mission.setId(0);
		missionService.save(mission);
		return mission;
	}

	@PutMapping("/missions")
	public Mission editMission(@RequestBody Mission mission) {
		missionService.save(mission);
		return mission;
	}

	@DeleteMapping("/missions/{missionId}")
	public String deleteMission(@PathVariable int missionId) {
		missionService.delete(missionId);
		return "Deleted mission id - " + missionId;

	}

}
