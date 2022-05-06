package com.sogeti.cucumber.stepdefinitions;

import com.sogeti.steps.HomePageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class HomeStepDefinitions {
    @Steps
    HomePageSteps homePageSteps;

    @Given("user is on the home page")
    public void givenUserOnTheHomePage() {
        homePageSteps.openHomePage();
    }

    @When("accept cookie if visible")
    public void acceptCookieIfVisible() {
        homePageSteps.acceptCookie(true);
    }


//    @Then("verify page with {string} header is displayed")
//    public void verifyPageWithHeaderIsDisplayed(String headerName) {
//        homePageSteps.verifyPageHeader(headerName);
//    }
//
//    @When("click on {string} if temperature is below {int} or {string} if temperature is above {int} degrees")
//    public void clickOnBuyButtonDependingOnTemperature(String buttonByTempBelow) {
//    }
}
