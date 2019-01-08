package com.spaceagencydatahub.rest;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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
import com.spaceagencydatahub.util.DateTimeConverterUtil;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private DateTimeConverterUtil dateTimeConverterUtil;

	private static Logger logger = Logger.getLogger(ProductController.class.getName());

	@GetMapping("/products")
	public List<Product> getProduct(@RequestParam(value = "id") List<Integer> ids) {
		return productService.getMultipleProducts(ids);
	}

	@GetMapping("/products/search")
	public List<Product> searchProduct(@RequestParam(value = "missionName") String missionName,
			@RequestParam(value = "productType") String productType,
			@RequestParam(value = "acquisitionDate") String acquisitionDate) {

		Date date = dateTimeConverterUtil.convertStringToDateTime(acquisitionDate);
		logger.info("Date "+ acquisitionDate);
		return productService.searchProduct(missionName, productType, date);
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
