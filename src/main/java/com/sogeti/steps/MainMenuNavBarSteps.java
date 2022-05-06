package com.sogeti.steps;


import com.sogeti.pages.components.MainMenuNavBar;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class MainMenuNavBarSteps extends ScenarioSteps {
    MainMenuNavBar mainMenuNavBar;
    @Step
    public void hoverOverTheMenuItem(String menuName) {
        mainMenuNavBar.mouseHoverOnMenuItem(menuName);
    }

    @Step
    public void clickOnTabLink(String urlName) {
        mainMenuNavBar.clickSubMenuLink(urlName);
    }
}
