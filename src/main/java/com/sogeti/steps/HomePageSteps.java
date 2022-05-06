package com.sogeti.steps;


import com.sogeti.pages.BasePage;
import com.sogeti.pages.components.MainMenuNavBar;
import com.sogeti.pages.components.NavBarGlobal;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class HomePageSteps extends ScenarioSteps {
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

    @Step
    public void acceptCookie(boolean ifVisible) {
        if (ifVisible) basePage.acceptCookieButton.waitUntilClickable().click();
    }

    @Step
    public void hoverOverTheMenuItem(String menuName) {
        mainMenuNavBar.mouseHoverOnMenuItem(menuName);
    }

    @Step
    public void clickOnTabLink(String urlName) {
        mainMenuNavBar.clickItemByCss(urlName, MainMenuNavBar.getSubMenuLinksCss());
    }

    @Step
    public void clickGlobalNavElement(String buttonName) {
        navBarGlobal.clickItemByCss(buttonName, NavBarGlobal.getNavBarGlobalDropdownButtonCss());
    }
}
