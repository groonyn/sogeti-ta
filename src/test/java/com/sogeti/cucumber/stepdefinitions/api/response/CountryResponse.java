package com.sogeti.cucumber.stepdefinitions.api.response;

public class CountryResponse {
    public static final String COUNTRY = "'country'";
    public static final String PLACES_PLACENAME = "'places'[0].'place name'";
    public static final String PLACE_FOR_POSTAL_CODE = "places.findAll { it.'post code' == '%1$s' }.'%2$s'[0]";
}
