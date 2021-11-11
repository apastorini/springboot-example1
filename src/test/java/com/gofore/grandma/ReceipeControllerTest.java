package com.gofore.grandma;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.nio.charset.Charset;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.repository.ReceipeRepository;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReceipeControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private ReceipeRepository receipeRepository;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + "/grandma-receipes" + uri;
	}

	@Test
	public void testHelloWorldEndpoint() throws Exception {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api-receipes/ping"), HttpMethod.GET,
				entity, String.class);

		String expected = "pong";

		assertEquals(expected, response.getBody());
	}
	
	@Test
	public void testWorthCaseA() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=XXXXX&who=GRANDSON");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"XXXXX\",\"worth\":\"INVALID\"}";

		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void testWorthCaseB() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345B&who=GRANDSON");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345B\",\"worth\":\"yeah\",\"prepare_time\":\"0.45\",\"portions\":\"5\"}";
		System.out.println(result.getBody());

		assertEquals(expected, result.getBody());
	}

	@Test
	public void testWorthCaseC() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345C&who=HUSBAND");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345C\",\"worth\":\"yeah\",\"prepare_time\":\"1\"}";
		System.out.println(result.getBody());
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void testWorthCaseD() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345D&who=GRANDSON");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345D\",\"worth\":\"yeah\",\"prepare_time\":\"1.50\",\"portions\":\"5\"}";
		System.out.println(result.getBody());
		assertEquals(expected, result.getBody());
	}

	
	@Test
	public void testWorthCaseE() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345E&who=HUSBAND");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345E\",\"worth\":\"meh\",\"prepare_time\":\"2.10\"}";
		System.out.println(result.getBody());
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void testWorthCaseF() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345F&who=GRANDSON");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345F\",\"worth\":\"yeah\",\"prepare_time\":\"2.55\"}";
		System.out.println(result.getBody());
		assertEquals(expected, result.getBody());
	}
	
	
	@Test
	public void testWorthCaseG() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345G&who=DAUGHTER");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345G\",\"worth\":\"meh\",\"prepare_time\":\"3\"}";
		System.out.println(result.getBody());
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void testWorthCaseH() throws Exception {

		URI uri = new URI(createURLWithPort("/api-receipes/receipes/worth/") + "?reference=12345H&who=HUSBAND");
		 
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("reference"));
		
		
		
		String expected = "{\"reference\":\"12345H\",\"worth\":\"nah\"}";
		System.out.println(result.getBody());
		assertEquals(expected, result.getBody());
	}

	
	@BeforeAll
	public void runBeforeAllTestMethods() {
		
		try {
			receipeRepository.deleteAll();
			//Caso Worth
			
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345B",1));
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345C",1));
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345D",2));
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345E",2));
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345F",3));
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345G",3));
			receipeRepository.saveAndFlush(UtilTest.createReceipeWorth("12345H",3));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@AfterAll
	public void runAfterAllTestMethods() {
		receipeRepository.deleteAll();
	}
}