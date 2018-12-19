package com.spaceagencydatahub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spaceagencydatahub.dao.MissionDAO;
import com.spaceagencydatahub.entity.Mission;

@Service
public class MissionService implements GenericService<Mission> {

	@Autowired
	private MissionDAO missionDAO;

	@Transactional
	public List<Mission> getAll() {
		return missionDAO.getAll();
	}

	@Transactional
	public void save(Mission mission) {
		missionDAO.save(mission);
	}

	@Transactional
	public Mission getOne(int id) {

		return missionDAO.getSingle(id);
	}

	@Transactional
	public void delete(int id) {
		missionDAO.delete(id);
	}

}
