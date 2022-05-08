package com.sogeti.ui.steps;


import com.sogeti.ui.pages.BasePage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class CommonSteps extends ScenarioSteps {
    BasePage basePage;

    /**
     * Verifies that current  url of page contains expected url value.
     *
     * @param urlName expected url value
     */
    @Step
    public void verifyCurrentPage(String urlName) {
        Ensure.thatTheCurrentPage().currentUrl().contains(urlName);
    }

    /**
     * Perform clicking on button element by partial button name adopted for Angular.
     *
     * @param elementName partial name of element to be found
     */
    @Step
    public void clickOnButtonByPartName(String elementName) {
        basePage.clickAngularButtonByPartName(elementName);
    }

    /**
     * Perform switching to new tab.
     **/
    @Step
    public void switchToNewTab() {
        basePage.switchToNewTab();
    }

    /**
     * Perform closing of  current tab.
     **/
    @Step
    public void closeTab() {
        basePage.closeTab();
    }

    /**
     * Perform switching back to previous tab.
     **/
    @Step
    public void switchBackToPrevTab() {
        basePage.switchBackToPrevTab();
    }
}
