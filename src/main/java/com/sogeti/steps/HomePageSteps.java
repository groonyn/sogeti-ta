package com.sogeti.steps;


import com.sogeti.pages.BasePage;
import com.sogeti.pages.HomePage;
import com.sogeti.pages.components.bars.MainMenuNavBar;
import com.sogeti.pages.components.bars.NavBarGlobal;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class HomePageSteps extends ScenarioSteps {
    HomePage homePage;
    BasePage basePage;
    MainMenuNavBar mainMenuNavBar;
    NavBarGlobal navBarGlobal;

    /**
     * Open entry point page for execution of tests.
     */
    @Step
    public void openHomePage() {
        basePage.open();
    }

    /**
     * Provides accepting of cookie during the first opening of the page. depending
     * on checking visibility before accepting or accepting without checking visibility.
     * if checkIfVisible parameter is false then trying to accept cookie without checking existence firstly.
     *
     * @param ifVisible boolean value of visibility condition
     */
    @Step
    public void acceptCookie(boolean ifVisible) {
        homePage.clickElementIfVisible(homePage.acceptCookieButton, ifVisible);
    }

    /**
     * Provides mouse hover action over the menu item by name.
     *
     * @param menuName item to perform hover over it
     */
    @Step
    public void hoverOverTheMenuItem(String menuName) {
        mainMenuNavBar.mouseHoverOnMenuItem(menuName);
    }

    /**
     * Provides clicking on tab link by its url.
     *
     * @param urlName url of item
     */
    @Step
    public void clickOnTabLink(String urlName) {
        mainMenuNavBar.clickOnSubMenuLink(urlName);
    }

    /**
     * Performs clicking on Global Nav element.
     *
     * @param buttonName name of the button to click.
     */
    @Step
    public void clickGlobalNavElement(String buttonName) {
        navBarGlobal.clickGlobalNavElement(buttonName);
    }

    /**
     * Verifies the visibility of every country in countires list of the dropdown.
     */
    @Step
    public void verifyWorldwideCountries() {
        navBarGlobal.countriesList.forEach(WebElementFacade::waitUntilVisible);
    }

    /**
     * Performs clicking on country dropdown item by its name.
     *
     * @param name name of country.
     */
    @Step
    public void clickOnCountryDropdownItem(String name) {
        navBarGlobal.clickOnCountryItem(name);
    }

    /**
     * Verifies that the current page url is containing the url stored in previously clicked dropdown country element.
     */
    @Step
    public void verifyCurrentPageUrl() {
        String currentUrl = getDriver().getCurrentUrl();
        String clickedElementUrl = Serenity.sessionVariableCalled("countryLink");
        Assert.assertThat(clickedElementUrl, is(containsString(currentUrl)));
    }
}
