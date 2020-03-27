package org.springframework.samples.petclinic.bdd.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;

@Log
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginStepDefinitions extends AbstractStep {

	@LocalServerPort
	private int port;
	
	@Given("I am not logged in the system")
	public void IamNotLogged() throws Exception{		
		getDriver().get("http://localhost:"+port);
		WebElement element=getDriver().findElement(By.xpath("//div[@id='main-navbar']/ul[2]/li/a"));
		if(element==null || !element.getText().equalsIgnoreCase("login")) {
			getDriver().findElement(By.xpath("//div[@id='main-navbar']/ul[2]/li/a/span[2]")).click();
			getDriver().findElement(By.linkText("Logout")).click();
			getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		}
	}
	
	@When("I do login as admin1")
	public void IdoLoginAs() throws Exception {
		String username="admin1";
		loginAs(username,passwordOf(username));		
	}
	
	private void loginAs(String username,String password) {				
		getDriver().findElement(By.xpath("//div[@id='main-navbar']/ul[2]/li/a")).click();
		getDriver().findElement(By.id("password")).clear();
		getDriver().findElement(By.id("password")).sendKeys(password);
		getDriver().findElement(By.id("username")).clear();
		getDriver().findElement(By.id("username")).sendKeys(username);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
	}
	private String passwordOf(String username) {
		return "4dm1n";
	}

	@Then("admin1 appears as the current user")
	public void asCurretUserAppears() throws Exception {
		String username="admin1";
		assertEquals(username.toUpperCase(),
				getDriver().findElement(By.xpath("//div[@id='main-navbar']/ul[2]/li/a/strong")).getText());
		stopDriver();
	}
	
	@When("I try to do login as admin1 with an invalid password")
	public void ItryToDoLoginWithAnInvalidPasswordAs() throws Exception {
		loginAs("admin1",UUID.randomUUID().toString());
	}
	
	@Then("the login form is shown again")
	public void theLoginFormIsShownAgain() throws Exception {
		assertEquals(getDriver().getCurrentUrl(),"http://localhost:"+port+"/login-error");
		stopDriver();
	}
	
}
