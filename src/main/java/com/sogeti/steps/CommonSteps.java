package com.sogeti.steps;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.WebElement;


/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class CommonSteps extends ScenarioSteps {
    @Step
    public void verifyCurrentPage(String urlName) {
        Ensure.thatTheCurrentPage().currentUrl().contains(urlName);
    }

}
