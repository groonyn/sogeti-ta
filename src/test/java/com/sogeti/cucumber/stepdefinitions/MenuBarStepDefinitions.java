package com.sogeti.cucumber.stepdefinitions;

import com.sogeti.pages.components.MainMenuNavBar;
import com.sogeti.steps.HomePageSteps;
import com.sogeti.steps.MainMenuNavBarSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class MenuBarStepDefinitions {
    @Steps
    MainMenuNavBarSteps mainMenuNavBarSteps;

    @When("hover over the {string} sub menu link")
    public void whenMoveHoverTheLink(String linkName) {
        mainMenuNavBarSteps.hoverOverTheMenuItem(linkName);
    }

    @When("click on {string} tab link")
    public void whenClickOnTabLink(String urlName) {
        mainMenuNavBarSteps.clickOnTabLink(urlName);
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
