package com.sogeti.cucumber.stepdefinitions.ui;

import com.sogeti.ui.steps.AutomationPageSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Provides Step Definitions class for Cucumber BDD approach.
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationStepDefinitions {
    @Steps
    AutomationPageSteps automationPageSteps;

    @Then("verify that page {string} header is displayed")
    public void thenVerifyPageHeader(String headerName) {
        automationPageSteps.verifyPageHeader(headerName);
    }

    @When("move to the {string} section")
    public void whenScrollDownToSection(String title) {
        //no ability to use selenium scroll, Angular JS on frontend
        automationPageSteps.moveToSection(title);
    }

    @When("fill the fields with random generated data:")
    public void whenScrollDownToSection(DataTable dataTable) {
        List<Map<String, String>> fieldsNamesMap = dataTable.asMaps(String.class, String.class);
        List<String> fields = new ArrayList<>(fieldsNamesMap.get(0).values());
        automationPageSteps.fillFieldsWIthRandomData(fields);
    }

    @When("check the {string} checkbox")
    public void whenClickOnCheckboxLabel(String labelName) {
        automationPageSteps.clickOnCheckbox(labelName);
    }
}
