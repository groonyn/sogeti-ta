package com.sogeti.pages;

import com.paulhammant.ngwebdriver.ByAngular;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides simple Page Object class with elements fields with defining entry url point.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
@DefaultUrl("https://www.sogeti.com/")
public class BasePage extends PageObject {
    /**
     * Provides finding and clicking on any item by its name and css, adopted for Angular.
     *
     * @param item name of item to be clicked
     * @param css  css value of item to be clicked
     */
    public void clickAngularItemByCss(String item, String css) {
        find(ByAngular.cssContainingText(css, item)).click();
    }

    /**
     * Provides clicking on any WebElementFacade element depending
     * on checking visibility before click or click without checking visibility.
     * if checkIfVisible parameter is false then trying to click element without checking existence firstly.
     *
     * @param element        WebElementFacade element.
     * @param checkIfVisible boolean value of visibility condition
     */
    public void clickElementIfVisible(WebElementFacade element, boolean checkIfVisible) {
        if (checkIfVisible) {
            if (element.isVisible()) element.waitUntilClickable().click();
        } else {
            element.waitUntilClickable().click();
        }
    }

    /**
     * Provides getting WebElementFacade element for the list by its name.
     *
     * @param elementsList list to be checked for the element
     * @param elementName  name of element to be found in list
     * @return WebElementFacade instance of found element
     * @throws NotFoundException exception if no element found in list
     */
    public WebElementFacade getElementByNameFromList(List<WebElementFacade> elementsList, String elementName) {
        for (WebElementFacade elementFacade : elementsList) {
            if (elementFacade.getText().equals(elementName)) {
                return elementFacade;
            }
        }
        throw new NotFoundException("Element with name '" + elementName + "' not found in the list.");
    }

    /**
     * Gets element by name using its css and name adopted for Angular.
     *
     * @param elementsCss list to be checked for the element
     * @param elementName name of element to be found in list
     * @return WebElementFacade instance of found element
     */
    public WebElementFacade getAngularElementByName(String elementsCss, String elementName) {
        return $(ByAngular.cssContainingText(elementsCss, elementName));
    }

    /**
     * Gets button element by partial button element name adopted for Angular.
     *
     * @param elementName partial name of element to be found
     * @return WebElementFacade instance of found element
     */
    public WebElementFacade getAngularButtonByName(String elementName) {
        return $(ByAngular.partialButtonText(elementName));
    }

    /**
     * Perform clicking on element  by css of element and its name adopted for Angular.
     *
     * @param elementsCss css of element to be found
     * @param elementName partial name of element to be found
     */
    public void clickAngularElementByName(String elementsCss, String elementName) {
        getAngularElementByName(elementsCss, elementName).click();
    }

    /**
     * Perform clicking on button element by partial button name adopted for Angular.
     *
     * @param elementName partial name of element to be found
     */
    public void clickAngularButtonByPartName(String elementName) {
        getAngularButtonByName(elementName).click();
    }

    /**
     * Perform move mouse action on element by its name from the provided elements list.
     *
     * @param elementsList list of provided elements to be searched in.
     * @param elementName  name of element to move mouse on.
     */
    public void moveToElementFromTheList(List<WebElementFacade> elementsList, String elementName) {
        new Actions(getDriver()).moveToElement(getElementByNameFromList(elementsList, elementName))
                .click().build().perform();
    }

    /**
     * Perform move mouse action on element.
     *
     * @param element element instance to move on.
     */
    public void moveToElement(WebElementFacade element) {
        new Actions(getDriver()).moveToElement(element)
                .click().build().perform();
    }

    /**
     * Perform scrolling down on element using JavaScript by 1000px.
     *
     * @param element element ot scroll on
     */
    public void scrollJsOnElementUntilVisible(WebElementFacade element) {
        for (int i = 0; i < 5; i++) {
            if (element.isCurrentlyVisible()) break;
            getJavascriptExecutorFacade().executeScript("window.scrollBy(0,1000)");
        }
    }

    /**
     * Perform setting value on element  using JavaScript.
     *
     * @param element element to set value on
     * @param value   value to be set
     */
    public void setValueJsOnElement(WebElement element, String value) {
        getJavascriptExecutorFacade().executeScript("arguments[0].value='" + value + "';", element);
    }

    /**
     * Perform switching to tab by its number.
     *
     * @param tabNo tab number to switch on.
     */
    public void switchToTab(int tabNo) {
        ArrayList<String> newTab = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(tabNo));
    }

    /**
     * Perform switching to new tab.
     **/
    public void switchToNewTab() {
        switchToTab(1);
    }

    /**
     * Perform switching back to previous tab.
     **/
    public void switchBackToPrevTab() {
        switchToTab(0);
    }

    /**
     * Perform closing of  current tab.
     **/
    public void closeTab() {
        getDriver().switchTo().window(getDriver().getWindowHandle()).close();
    }
}