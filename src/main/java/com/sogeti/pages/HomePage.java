package com.sogeti.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * Provides simple Page Object class with elements fields with defining entry url point.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */

@DefaultUrl("https://www.sogeti.com/")
public class HomePage extends PageObject {
    @FindBy(css = "button.acceptCookie")
    public WebElementFacade acceptCookieButton;
}
