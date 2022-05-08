package com.sogeti.ui.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class HomePage extends BasePage {
    @FindBy(css = "button.acceptCookie")
    public WebElementFacade acceptCookieButton;
}
