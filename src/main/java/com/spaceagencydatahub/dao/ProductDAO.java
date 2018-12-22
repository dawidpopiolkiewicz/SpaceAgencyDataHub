package com.spaceagencydatahub.dao;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spaceagencydatahub.entity.Product;

@Repository
public class ProductDAO implements GenericDAO<Product> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product").list();
		return products;
	}

	public List<Product> getMultipleProducts(List<Integer> ids) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> multipleProducts = (List<Product>) session.createQuery("from Product where id in :ids")
				.setParameter("ids", ids).getResultList();

		return multipleProducts;
	}

	public List<Product> searchProduct(String missionName, String productType, OffsetDateTime acquisitionDate) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("").setParameter("missionName", missionName)
				.setParameter("acquisitionDate", acquisitionDate).setParameter("productType", productType)
				.getResultList();
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
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.byId(Product.class).load(id);
		session.delete(product);
	}

	public List<Product> findByMissionNameAndProducType(String missionName, String productType) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session
				.createQuery(
						"from Product where mission_name=:missionName in (from Mission where imagery_type=:productType")
				.setParameter("missionName", missionName).setParameter("productType", productType).getResultList();

		System.out.println(missionName);
		System.out.println(productType);
		return products;
	}

}
