package com.spaceagencydatahub.rest;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spaceagencydatahub.entity.Product;
import com.spaceagencydatahub.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getProduct(@RequestParam(value = "id") List<Integer> ids) {
		return productService.getMultipleProducts(ids);
	}

	@GetMapping("/products/search")
	public List<Product> searchProduct(@RequestParam(value = "missionName") String missionName,
			@RequestParam(value = "productType") String productType,
			@RequestParam(value = "acquisitionDate") OffsetDateTime acquisitionDate
	) {
		return productService.searchProduct(missionName, productType, acquisitionDate);
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
