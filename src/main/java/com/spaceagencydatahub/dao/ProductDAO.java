package com.spaceagencydatahub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spaceagencydatahub.entity.Product;

@Repository
public class ProductDAO implements GenericDAO<Product>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product").list();
		return products;
	}

	@Override
	public Product save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		return null;
	}

	@Override
	public Product getSingle(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class,id);
		return product;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.byId(Product.class).load(id);
		session.delete(product);
	}

}
