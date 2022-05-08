package com.sogeti.ui.pages.components.bars;

import com.sogeti.ui.pages.HomePage;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Provides simple Page Object class with elements fields.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class MainMenuNavBar extends HomePage {
    @FindBy(css = "#main-menu  li.has-children span")
    private List<WebElementFacade> mainMenuItems;

    @Getter
    private static final String SUB_MENU_LINKS_CSS = "div.mega-navbar a.subMenuLink";

    /**
     * Provides move hover action over the WebElement.
     */
    public void mouseHoverOnMenuItem(String menuItem) {
        new Actions(getDriver()).moveToElement(getElementByNameFromList(mainMenuItems, menuItem)).perform();
    }

    /**
     * Performs clicking on submenu link by css adopted for Angular
     *
     * @param urlName submenu link to click
     */
    public void clickOnSubMenuLink(String urlName) {
        clickAngularItemByCss(urlName, SUB_MENU_LINKS_CSS);
    }
}
