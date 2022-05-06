package com.sogeti.cucumber.stepdefinitions;

import com.sogeti.steps.AutomationPageSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

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

    @When("scroll down to the {string} section")
    public void whenScrollDownToSection(String sectionName) {
        automationPageSteps.scrollDownToSection(sectionName);
    }

    @When("fill the fields with random data:")
    public void whenFillFieldByRandomData(List<String> fieldsNames) {
        automationPageSteps.fillFieldsWIthRandomData(fieldsNames);
    }
}
