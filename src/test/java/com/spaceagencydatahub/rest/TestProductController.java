package com.spaceagencydatahub.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceagencydatahub.entity.Product;
import com.spaceagencydatahub.service.ProductService;

public class TestProductController {

	private static Logger logger = Logger.getLogger(TestProductController.class.getName());

	@InjectMocks
	private ProductController productController;
	@Mock
	private ProductService productService;

	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			logger.info(description.getMethodName() + " " + "started");

		}

		@Override
		protected void succeeded(Description description) {
			logger.info(description.getMethodName() + " " + "success");
		}

		@Override
		protected void failed(Throwable e, Description description) {
			logger.warning(description.getMethodName() + " " + "FAILED!" + " " + e.getMessage());
		}

		@Override
		protected void finished(Description description) {
			logger.info(description.getMethodName() + " " + "completed");
		}

	};

	@Before
	public void setup() {
		objectMapper = new ObjectMapper();
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testFindById() throws Exception {
		this.mockMvc.perform(get("/api/products?id=1")).andExpect(status().isOk());
	}

	@Test
	public void testGetMultipleProducts() throws Exception {
		this.mockMvc.perform(get("/api/products?id=1&id=2&id=3")).andExpect(status().isOk());
	}

	@Test
	public void testAddProduct() throws Exception {

		String productJson = "{\r\n" + "        \"mission_name\": \"test_mission6\",\r\n"
				+ "        \"acquisitionDate\": \"2018-11-06T10:54:16+00:00\",\r\n" + "        \"footprint\": {\r\n"
				+ "            \"pointW\": 0,\r\n" + "            \"pointX\": 0,\r\n" + "            \"pointY\": 0,\r\n"
				+ "            \"pointZ\": 0\r\n" + "        },\r\n" + "        \"price\": 2000.5,\r\n"
				+ "        \"url\": \"https://picsum.photos/200/300/?random\"\r\n" + "    }";

		Product product = objectMapper.readValue(productJson, Product.class);
		this.mockMvc.perform(post("/api/products").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(product))).andExpect(status().isOk());

	}

}
