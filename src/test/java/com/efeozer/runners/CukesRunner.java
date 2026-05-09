package com.efeozer.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },

        features = "src/test/resources/features",
        glue = "com/efeozer/stepdefinitions",
        dryRun = false,
        monochrome = true
)

public class CukesRunner {
}