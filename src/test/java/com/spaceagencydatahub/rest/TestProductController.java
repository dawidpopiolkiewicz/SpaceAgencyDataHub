package com.spaceagencydatahub.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import java.time.OffsetDateTime;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceagencydatahub.entity.Footprint;
import com.spaceagencydatahub.entity.Product;
import com.spaceagencydatahub.service.ProductService;

public class TestProductController {

	private static Logger logger = Logger.getLogger(TestProductController.class.getName());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void succeeded(Description description) {
			logger.info(description.getMethodName() + " " + "success!");
		}

		@Override
		protected void failed(Throwable e, Description description) {
			logger.info(description.getMethodName() + " Failed!" + " " + e.getMessage());
		}

		@Override
		protected void finished(Description description) {
			 logger.info("Completed!");
		}

	};

	@InjectMocks
	private ProductController productController;
	@Mock
	private ProductService productService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void findById() throws Exception {
		this.mockMvc.perform(get("/api/products?id=1")).andExpect(status().isOk());
	}

	@Test
	public void testGetMultipleProducts() throws Exception {
		this.mockMvc.perform(get("/api/products?id=1&id=2&id=3")).andExpect(status().isOk());
	}

	@Test
	public void addProduct() throws Exception {
		OffsetDateTime offSetDateTime = OffsetDateTime.now();
		URL url = new URL("http://example.com/");
		Footprint footprint = new Footprint();
		ObjectMapper objectMapper = new ObjectMapper();

		footprint.setPointW(1.1);
		footprint.setPointX(2.2);
		footprint.setPointY(3.3);
		footprint.setPointZ(4.4);

		Product product = new Product();
		product.setAcquisitionDate(offSetDateTime);
		product.setFootprint(footprint);
		product.setId(4);
		product.setMission_name("mission1");
		product.setPrice(3000.500);
		product.setUrl(url);

		this.mockMvc.perform(post("/api/products").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(product))).andExpect(status().isOk());

	}

}
