package com.sogeti.steps;


import com.sogeti.pages.HomePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class HomePageSteps extends ScenarioSteps {
    HomePage homePage;

    /**
     * Open entry point page for execution of tests.
     */
    @Step
    public void openHomePage() {
        homePage.open();
    }
    @Step
    public void acceptCookie(boolean ifVisible) {
        if (ifVisible) homePage.acceptCookieButton.waitUntilClickable().click();
    }
}
