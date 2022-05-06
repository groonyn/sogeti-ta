package com.sogeti.cucumber.stepdefinitions;

import com.sogeti.steps.AutomationPageSteps;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationStepDefinitions {
    @Steps
    AutomationPageSteps automationPageSteps;
    @Then("verify that page {string} header is displayed")
    public void thenVerifyPageHeader(String headerName) {
        automationPageSteps.verifyPageHeader(headerName);
    }
}
