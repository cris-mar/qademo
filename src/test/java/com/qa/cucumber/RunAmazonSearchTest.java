package com.qa.cucumber;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "json:target/cucumber/amazon.json",
                "html:target/cucumber/amazon.html",
                "pretty"
        },
        features = {"Feature"}
)
public class RunAmazonSearchTest {
}
