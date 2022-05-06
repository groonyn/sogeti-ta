package com.sogeti.pages;

import com.paulhammant.ngwebdriver.ByAngular;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Provides simple Page Object class with elements fields with defining entry url point.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */

@DefaultUrl("https://www.sogeti.com/")
public class BasePage extends PageObject {
    @FindBy(css = "button.acceptCookie")
    public WebElementFacade acceptCookieButton;

    public void clickItemByCss(String item, String css) {
        find(ByAngular.cssContainingText(css, item)).click();
    }
    public WebElementFacade getElementByNameFromList(List<WebElementFacade> elementsList, String elementName) {
        return elementsList.stream()
                .filter(elementFacade -> elementFacade.waitUntilPresent().getText().equals(elementName))
                .findFirst().orElseThrow(() ->
                        new NotFoundException("Element with name + " + elementName + "is not found in the list."));
    }
}
