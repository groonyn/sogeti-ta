package com.sogeti.pages.components;

import com.sogeti.pages.BasePage;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainMenuNavBar extends BasePage {
    @FindBy(css = "#main-menu  li.has-children span")
    private List<WebElementFacade> mainMenuItems;

    @Getter
    private static final String subMenuLinksCss = "div.mega-navbar a.subMenuLink";

    public void mouseHoverOnMenuItem(String menuItem) {
        new Actions(getDriver()).moveToElement(getElementByNameFromList(mainMenuItems, menuItem)).perform();
    }
}

