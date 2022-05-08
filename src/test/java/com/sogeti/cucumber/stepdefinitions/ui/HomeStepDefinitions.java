package com.sogeti.cucumber.stepdefinitions.ui;

import com.sogeti.ui.steps.HomePageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
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

    @When("hover over the {string} sub menu link")
    public void whenMoveHoverTheLink(String linkName) {
        homePageSteps.hoverOverTheMenuItem(linkName);
    }

    @When("click on {string} tab link")
    public void whenClickOnTabLink(String urlName) {
        homePageSteps.clickOnTabLink(urlName);
    }

    @When("click on {string} global item")
    public void whenClickOnGlobalNavElement(String name) {
        homePageSteps.clickGlobalNavElement(name);
    }

    @Then("verify Countries dropdown items are visible")
    public void thenVerifyCountriesVisible() {
        homePageSteps.verifyWorldwideCountries();
    }

    @Then("click on {string} country from the dropdown")
    public void whenClickOnCountryDropdownItem(String name) {
        homePageSteps.clickOnCountryDropdownItem(name);
    }

    @Then("verify current page contains url as in previously clicked dropdown item")
    public void thenVerifyCurrentPageUrl() {
        homePageSteps.verifyCurrentPageUrl();
    }
}