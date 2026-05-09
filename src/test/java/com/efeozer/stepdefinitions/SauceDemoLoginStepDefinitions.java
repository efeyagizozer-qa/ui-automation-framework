package com.efeozer.stepdefinitions;

import com.efeozer.pages.SauceDemoLoginPage;
import com.efeozer.utilities.ConfigurationReader;
import com.efeozer.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SauceDemoLoginStepDefinitions {

    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();

    @Given("user is on SauceDemo login page")
    public void user_is_on_SauceDemo_login_page(){
        Driver.getDriver().get(
                ConfigurationReader.getProperty("url"));
        // Reads URL dynamically from configuration.properties
    }


    @When("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() {

        sauceDemoLoginPage.username.sendKeys(
                ConfigurationReader.getProperty("username"));

        sauceDemoLoginPage.password.sendKeys(
                ConfigurationReader.getProperty("password"));
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {

        sauceDemoLoginPage.loginButton.click();

    }

    @Then("user should see inventory page")
    public void userShouldSeeInventoryPage() {

        Assert.assertTrue(
                Driver.getDriver()
                        .getCurrentUrl()
                        .contains("inventory")
        );


    }
}
