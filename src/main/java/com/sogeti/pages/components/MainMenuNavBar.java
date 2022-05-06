package com.sogeti.pages.components;

import com.sogeti.Utils;
import com.sogeti.pages.AutomationPage;
import com.sogeti.pages.HomePage;
import com.sogeti.steps.CommonSteps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainMenuNavBar extends HomePage {
    @FindBy(css = "#main-menu  li.has-children span")
    private List<WebElementFacade> mainMenuItems;

    private String subMenuLinksCss = "#main-menu a.subMenuLink";

    public MainMenuNavBar mouseHoverOnMenuItem(String menuItem) {
        mainMenuItems.stream().filter(mainMenuItem -> mainMenuItem.waitUntilPresent().getText().equals(menuItem))
                .findFirst().ifPresent(mainMenuItem -> new Actions(getDriver()).moveToElement(mainMenuItem).perform());
        return this;
    }

    public void clickSubMenuLink(String subItem) {
        List<WebElementFacade> subMenuLinks = $$(subMenuLinksCss);
        subMenuLinks.stream().filter(WebElementState::isPresent)
                .filter(webElementFacade -> webElementFacade.waitUntilPresent().getAttribute("href")
                        .contains(subItem)).findFirst().ifPresent(webElementFacade -> new Utils()
                        .clickJsOnElement(webElementFacade));
    }
}
