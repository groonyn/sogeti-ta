package com.sogeti.steps;


import com.sogeti.DataGenerator;
import com.sogeti.pages.AutomationPage;
import com.sogeti.pages.components.forms.ContactUsForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.Matchers.is;

/**
 * Provides class in Step Design manner with steps logic for Scenarios.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class AutomationPageSteps extends ScenarioSteps {
    AutomationPage automationPage;
    ContactUsForm contactUsForm;

    /**
     * Verifies current page header of opened page
     *
     * @param headerName The name of page header to be verified
     */
    @Step
    public void verifyPageHeader(String headerName) {
        String pageHeader = automationPage.title.waitUntilVisible().getText();
        Assert.assertThat(pageHeader, is(Matchers.equalTo(headerName)));
    }

    /**
     * Perform move to section by its title
     *
     * @param title section title
     */
    @Step
    public void moveToSection(String title) {
        contactUsForm.moveToElementFromTheList(automationPage.sectionTitles, title);
    }

    /**
     * Perform filling of fields by random data using random data generator
     *
     * @param fieldsNames the list of fields names (titles) to be filled.
     */
    @Step
    public void fillFieldsWIthRandomData(List<String> fieldsNames) {
        for (int i = 0; i < fieldsNames.size(); i++) {
            contactUsForm.moveToElement(contactUsForm.contactUsFields.get(i));

            String fieldName = fieldsNames.get(i);
            switch (fieldName) {
                case ContactUsForm.FIRST_NAME:
                case ContactUsForm.LAST_NAME:
                case ContactUsForm.COMPANY:
                case ContactUsForm.MESSAGE:
                    contactUsForm.fillFieldWithData(fieldName, DataGenerator.generateRandomString(10));
                case ContactUsForm.EMAIL:
                    contactUsForm.fillFieldWithData(fieldName, DataGenerator.generateEmail(10));
                case ContactUsForm.PHONE:
                    contactUsForm.fillFieldWithData(fieldName, DataGenerator.generateRandomNumber(10));
                    break;
            }
        }
    }

    /**
     * Perform clicking on checkbox by checkbox element name.
     *
     * @param elementName checkbox element name
     */
    @Step
    public void clickOnCheckbox(String elementName) {
        contactUsForm.checkCheckBoxItem(elementName);
    }
}
