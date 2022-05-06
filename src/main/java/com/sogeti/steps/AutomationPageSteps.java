package com.sogeti.steps;


import com.sogeti.pages.AutomationPage;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationPageSteps extends ScenarioSteps {
    AutomationPage automationPage;

    /**
     * Verifies current page header of opened page
     *
     * @param headerName The name of page header to be verified
     */
    @Step
    public void verifyPageHeader(String headerName) {
        String pageHeader = automationPage.title.waitUntilVisible().getText();
        Assert.assertThat(pageHeader, is(Matchers.equalTo(headerName)));
    }

    @Step
    public void scrollDownToSection(String sectionName) {
        automationPage.scrollDownOnTopToSection(sectionName);
    }
    @Step
    public void fillFieldsWIthRandomData(List<String> fieldsNames) {

    }
}
