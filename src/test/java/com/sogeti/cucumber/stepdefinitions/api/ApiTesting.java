package com.sogeti.cucumber.stepdefinitions.api;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class ApiTesting extends ApiBaseTest {

    @Test
    public void getPlaces() {
        given()
                .when()
                .get("de/bw/stuttgart")
                .prettyPeek()
                .then()
                .time(Matchers.lessThan(1L), TimeUnit.SECONDS)
                .statusCode(200)
                .contentType(JSON)
                .body("country", equalTo("Germany"), "state", equalTo("Baden-Württemberg"))
                .body("places.findAll { it.'post code' == '70597' }.'place name'[0]", equalTo("Stuttgart Degerloch"));

    }

    @Test
    public void getCountryPostalCode(String country, String postalCode) {
        given()
                .when()
                .get("/" + country + "/" + postalCode)
                .prettyPeek()
                .then()
                .time(Matchers.lessThan(1L), TimeUnit.SECONDS)
                .statusCode(200)
                .contentType(JSON)
                .body("country", equalTo("Germany"), "state", equalTo("Baden-Württemberg"))
                .body("places.findAll { it.'post code' == '70597' }.'place name'[0]", equalTo("Stuttgart Degerloch"));

    }
}
