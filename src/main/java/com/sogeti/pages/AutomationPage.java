package com.sogeti.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Provides simple Page Object class with elements fields with defining entry url point.
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationPage extends PageObject {
    @FindBy(css = "#primary_content  h1 > span")
    public WebElementFacade title;

}
