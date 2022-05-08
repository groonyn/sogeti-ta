package com.sogeti.pages.components.bars;

import com.sogeti.pages.HomePage;
import lombok.Getter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Provides simple Page Object class with elements fields.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class NavBarGlobal extends HomePage {
    @FindBy(css = COUNTRY_DROPDOWN_ITEM_CSS)
    public List<WebElementFacade> countriesList;
    @Getter
    private static final String NAV_BAR_GLOBAL_DROPDOWN_BUTTON_CSS = "div.navbar-global.focus-style > span";
    @Getter
    private static final String COUNTRY_DROPDOWN_ITEM_CSS = "#country-list-id a";

    /**
     * Performs clicking on Global Nav button adopted for Angular.
     *
     * @param buttonName name of the button to click.
     */
    public void clickGlobalNavElement(String buttonName) {
        clickAngularItemByCss(buttonName, NAV_BAR_GLOBAL_DROPDOWN_BUTTON_CSS);
    }

    /**
     * Gets country element by its name adopted for Angular.
     *
     * @param name name of element to get.
     */
    public WebElementFacade getCountryElement(String name) {
        return getAngularElementByName(COUNTRY_DROPDOWN_ITEM_CSS, name);
    }

    /**
     * Performs clicking on Country item by its name adopted for Angular.
     *
     * @param name name of the country item to click.
     */
    public void clickOnCountryItem(String name) {
        WebElementFacade country = getCountryElement(name);
        Serenity.setSessionVariable("countryLink").to(country.getAttribute("href"));
        country.click();
    }
}
