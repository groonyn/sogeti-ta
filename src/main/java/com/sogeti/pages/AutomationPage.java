package com.sogeti.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Provides simple Page Object class with elements fields with defining entry url point.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationPage extends BasePage {
    @FindBy(css = "#primary_content  h1 > span")
    public WebElementFacade title;

    @FindBy(css = "h2")
    public List<WebElementFacade> sectionsTitles;
    public void scrollDownOnTopToSection(String sectionName) {
        Scroll.to(getElementByNameFromList(sectionsTitles, sectionName)).andAlignToTop();
    }
}
