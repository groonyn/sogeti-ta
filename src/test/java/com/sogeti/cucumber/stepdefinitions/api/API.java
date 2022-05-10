package com.sogeti.cucumber.stepdefinitions.api;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * Defines methods to work with api.
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class API {
    private static final String COUNTRY_AND_POSTCODE = "/{country}/{postcode}";
    private static final String DEFAULT_URL = "http://api.zippopotam.us";
    private static final String POSTCODE = "postcode";
    private static final String COUNTRY = "country";
    private static final String DELIMITER = "/";

    //No ability to use RequestSpecification due to the reflection error of Serenity,
    //need to change its version, so we use basUri

    @Step("get places by {0} country abbreviation and {1} country code and {2} location")
    public void getCountryAbbrPlaces(String countryAbbreviation, String code, String location) {
        String uri = COUNTRY_AND_POSTCODE + DELIMITER + location;
        SerenityRest.given()
                .baseUri(DEFAULT_URL)
                .pathParam(POSTCODE, code)
                .pathParam(COUNTRY, countryAbbreviation)
                .get(uri)
                .prettyPeek();

    }

    @Step("Get location by postcode {0} in country {1}")
    public void getLocation(String postcode, String country) {
        SerenityRest.given()
                .baseUri(DEFAULT_URL)
                .pathParam(POSTCODE, postcode)
                .pathParam(COUNTRY, country)
                .get(COUNTRY_AND_POSTCODE)
                .prettyPeek();
    }
}
