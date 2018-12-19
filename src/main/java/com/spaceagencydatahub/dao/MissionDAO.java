package com.spaceagencydatahub.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spaceagencydatahub.entity.Mission;


@Repository
public class MissionDAO implements GenericDAO<Mission> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Mission> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Mission> missions = session.createQuery("from Mission").list();
		
		return missions;
	}

	@Override
	public Mission getSingle(int id) {
		Session session = sessionFactory.getCurrentSession();
		Mission mission = session.get(Mission.class, id);
		return mission;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Mission mission = session.byId(Mission.class).load(id);
		session.delete(mission);
	}

	@Override
	public Mission save(Mission mission) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mission);
		return mission;

	}

}
