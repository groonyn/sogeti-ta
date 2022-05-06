package com.sogeti;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Utils {
    /**
     * Performs clicking on element using JavaScript command.
     *
     * @param element WebElement to be clicked
     */
    @Step
    public void clickJsOnElement(WebElementFacade element) {
        new JavascriptExecutorFacade(getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs setting the value to the field.
     *
     * @param element WebElement to set value inside
     * @param value   value to be set in field
     */
    @Step
    public void setValueJsOnElement(WebElement element, String value) {
        new JavascriptExecutorFacade(getDriver()).executeScript("arguments[0].value='" + value + "';", element);
    }
}
