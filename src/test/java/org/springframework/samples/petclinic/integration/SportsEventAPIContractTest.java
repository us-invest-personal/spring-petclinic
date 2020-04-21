package org.springframework.samples.petclinic.integration;

import static io.restassured.RestAssured.with;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.samples.petclinic.model.Odd;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
@Log
public class SportsEventAPIContractTest {
	@Test
	public void testDefaultEvent() {		
		when()
			.get("http://localhost:8080/sportEvents/390")			
		.then()			
			.statusCode(200)
		  	.assertThat()
	      		.body("data.leagueId", equalTo(1))
	      	.and()
	      		.body("data.homeTeam",equalTo("Betis"));
		
	}	
	
	@Test
	public void testOddsPresent() {
		when()
			.get("http://localhost:8080/sportEvents/390")
		.then()
			.assertThat()
				.body("odds.price", 
					hasItems("1.25", "1.35"));
	}
	
	@Test
	public void whenRequestedPost_thenCreated() {
	    Odd odd=new Odd();
	    odd.setName("Empate");
	    odd.setPrice("0.3");
		with()
	    	.body(odd)
	    .when()
	      .post("http://localhost:8080/sportEvents/390/odds")
	    .then()
	      .statusCode(201)
	      .assertThat()
	      	.body("name",equalTo("Empate"));
	}
}
