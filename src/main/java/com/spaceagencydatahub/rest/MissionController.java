package com.spaceagencydatahub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	public void setMissionService(MissionService missionService) {
		this.missionService = missionService;
	}

	@GetMapping("/missions")
	public List<Mission> getMissions() {
		return missionService.getAll();
	}

	@GetMapping("/missions/{missionId}")
	public Mission getMission(@PathVariable int missionId) {

		Mission mission = missionService.getOne(missionId);
		if (mission == null) {
			System.out.println("missionnot found");
		}

		return mission;
	}

	@PostMapping("/missions")
	public Mission addMission(@RequestBody Mission mission) {
		mission.setId(0);
		missionService.save(mission);
		return mission;
	}

	@PutMapping("/missions")
	public Mission edit(@RequestBody Mission mission) {
		missionService.save(mission);
		return mission;
	}
	
	
	
	@DeleteMapping("/missions/{missionId}")
	public String deleteMission(@PathVariable int missionId) {

		missionService.delete(missionId);
		return "Deleted mission id - " + missionId;

	}

}
