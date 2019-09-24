package com.cedaniel200.example.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/compare_transactions_information_atm.feature"},
        glue = {"com.cedaniel200.example.stepdefinitions"},
        snippets = CAMELCASE)
public class CompareTransactionsInformationAtm {
}
