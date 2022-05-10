package com.sogeti.cucumber.stepdefinitions.api;

import com.sogeti.cucumber.stepdefinitions.api.response.CountryResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Provides Http Step Definitions class for Cucumber BDD approach.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class HttpStepDefinitions {

    @Steps
    API api;

    @When("user get places by {string} country abbreviation and {string} country code and {string} location")
    public void whenGetCountryAbbrPlaces(String countryAbbreviation, String code, String location) {
        api.getCountryAbbrPlaces(countryAbbreviation, code, location);
    }

    @When("user get postal code {string} for country code {string}")
    public void whenGetPostalCode(String postCode, String country) {
        api.getLocation(postCode, country);
    }

    @Then("verify that the place is {string} in country {string}")
    public void thenVerifyPostCodeResponse(String placeName, String country) {
        restAssuredChecks();
        restAssuredThat(response -> response.body(CountryResponse.COUNTRY, equalTo(country)));
        restAssuredThat(response -> response.body(CountryResponse.PLACES_PLACENAME, equalTo(placeName)));
    }

    @Then("verify that {string} is {string} and {string} is {string}")
    public void thenVerifyCountryAndStateByCodes(String countryKey, String countryValue,
                                                 String stateKey, String stateValue) {
        restAssuredChecks();
        restAssuredThat(response -> response.body(countryKey, equalTo(countryValue)));
        restAssuredThat(response -> response.body(stateKey, equalTo(stateValue)));
    }

    @Then("verify for postal code {string} the {string} has {string}")
    public void thenThePlaceNameForPostalCode(String postalCode, String placeNameKey, String placeNameValue) {
        restAssuredChecks();
        String groovySearch = String.format(CountryResponse.PLACE_FOR_POSTAL_CODE, postalCode, placeNameKey);
        restAssuredThat(response -> response.body(groovySearch, equalTo(placeNameValue)));
    }

    private void restAssuredChecks() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.contentType(ContentType.JSON));
        restAssuredThat(response -> response.time(Matchers.lessThan(3L), TimeUnit.SECONDS));
    }
}
