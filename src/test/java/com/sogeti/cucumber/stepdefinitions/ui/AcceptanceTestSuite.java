package com.sogeti.cucumber.stepdefinitions.ui;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Provides Serenity Cucumber basic runner class for running tests using JUnit.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@UI_Tests",
        plugin = {"pretty"},
        features = "src/test/resources/features"
)
public class AcceptanceTestSuite {
}