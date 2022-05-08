package com.sogeti.cucumber.stepdefinitions.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public abstract class ApiBaseTest {
    protected RequestSpecification requestSpecification;

    @Before
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
        RestAssured.requestSpecification = requestSpecification;
    }
}
