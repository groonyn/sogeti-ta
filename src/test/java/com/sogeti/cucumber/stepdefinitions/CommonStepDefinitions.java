package com.sogeti.cucumber.stepdefinitions;

import com.sogeti.steps.CommonSteps;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class CommonStepDefinitions {
    @Steps
    CommonSteps commonSteps;
    @Then("verify page {string} is opened")
    public void thenVerifyPageOpened(String headerName) {
        commonSteps.verifyCurrentPage(headerName);
    }
}
