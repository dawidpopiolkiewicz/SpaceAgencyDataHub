package com.spaceagencydatahub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spaceagencydatahub.entity.Product;
import com.spaceagencydatahub.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;


	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAll();
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		product.setId(0);
		productService.save(product);
		return product;
	}

	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		productService.delete(productId);
	}

}
