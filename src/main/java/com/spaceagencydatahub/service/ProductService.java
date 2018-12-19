package com.spaceagencydatahub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spaceagencydatahub.dao.ProductDAO;
import com.spaceagencydatahub.entity.Product;

@Service
public class ProductService implements GenericService<Product> {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	public List<Product> getAll() {
		return productDAO.getAll();
	}

	@Transactional
	public void save(Product product) {
		productDAO.save(product);
	}

	@Transactional
	public Product getOne(int id) {

		return productDAO.getSingle(id);
	}

	@Transactional
	public void delete(int id) {
		productDAO.delete(id);
	}

}
