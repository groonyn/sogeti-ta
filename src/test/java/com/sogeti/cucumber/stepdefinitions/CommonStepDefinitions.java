package com.sogeti.cucumber.stepdefinitions;

import com.sogeti.steps.CommonSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class CommonStepDefinitions {
    @Steps
    CommonSteps commonSteps;

    @Then("verify page {string} is opened")
    public void thenVerifyPageOpened(String headerName) {
        commonSteps.verifyCurrentPage(headerName);
    }

    @When("click on {string} button")
    public void whenClickOnButton(String elementName) {
        commonSteps.clickOnButtonByPartName(elementName);
    }

    @When("switch to new tab")
    public void whenSwitchToNewTab() {
        commonSteps.switchToNewTab();
    }

    @When("close tab")
    public void whenCloseTab() {
        commonSteps.closeTab();
    }

    @When("switch back to previous tab")
    public void whenSwitchBackToPrevTab() {
        commonSteps.switchBackToPrevTab();
    }
}