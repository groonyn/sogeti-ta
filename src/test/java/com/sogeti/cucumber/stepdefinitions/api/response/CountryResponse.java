package com.sogeti.cucumber.stepdefinitions.api.response;
/**
 * Stores data for responses verifications.
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class CountryResponse {
    public static final String COUNTRY = "'country'";
    public static final String PLACES_PLACENAME = "'places'[0].'place name'";
    public static final String PLACE_FOR_POSTAL_CODE = "places.findAll { it.'post code' == '%1$s' }.'%2$s'[0]";
}
