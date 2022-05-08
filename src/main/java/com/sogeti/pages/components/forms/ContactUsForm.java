package com.sogeti.pages.components.forms;

import com.sogeti.pages.AutomationPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Provides simple Page Object class with elements fields.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class ContactUsForm extends AutomationPage {
    @FindBy(css = CONTACT_US_FIELDS_CSS)
    public List<WebElementFacade> contactUsFields;
    private static final String CONTACT_US_FIELDS_CSS = "label.Form__Element__Caption";
    private static final String ELEMENTS_INPUTS_XPATH = "//label[contains(text(),'%s')]//following-sibling::textarea|input";
    private static final String CHECKBOX_LABEL_CSS = "fieldset label";
    public static final String FIRST_NAME = "First Name";
    public static final String LAST_NAME = "Last Name";
    public static final String EMAIL = "Email";
    public static final String PHONE = "Phone";
    public static final String COMPANY = "Company";
    public static final String MESSAGE = "Message";

    /**
     * Performs check of checkbox item by name adopted for Angular.
     *
     * @param elementName name of checkbox to check.
     */
    public void checkCheckBoxItem(String elementName) {
        clickAngularElementByName(CHECKBOX_LABEL_CSS, elementName);
    }

    /**
     * Provides filling of Contact Us form fields by random data.
     *
     * @param label title of input or textarea field to be filled.
     * @param data  data to be filled with.
     */
    public void fillFieldWithData(String label, String data) {
        //TODO: Actions() move does not work. can not use js or angular
        //approach because need to use xpath, css has no option to search with text.
        //also no ability to submit successfully, CAPTCHA is a blocker
        //need to use native js or protractor as possible solution
        waitForAngularRequestsToFinish();
        WebElementFacade e = getAngularElementByName(CONTACT_US_FIELDS_CSS, label);
        scrollJsOnElementUntilVisible(e);
        String xPath = String.format(ELEMENTS_INPUTS_XPATH, label);
        moveTo(By.xpath(xPath));
        WebElementFacade enabledElement = $(xPath).waitUntilEnabled();
        setValueJsOnElement(enabledElement, data);
    }
}
