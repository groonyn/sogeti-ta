package com.sogeti.ui.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Provides simple Page Object class with elements fields.
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationPage extends BasePage {
    @FindBy(css = "#primary_content  h1 > span")
    public WebElementFacade title;
    @FindBy(css = "h2")
    public List<WebElementFacade> sectionTitles;
}
