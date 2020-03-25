package org.springframework.samples.petclinic.bdd;


import io.cucumber.junit.CucumberOptions;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",plugin = "json:target/cucumber-report.json")
public class CucumberTest {
}
