package com.cedaniel200.example.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.cedaniel200.example.interactions.AtmFilesComparator.compareATMFiles;
import static com.cedaniel200.example.question.MismatchedTransactionReviewer.theInformationIsCorrect;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompareTransactionsInformationAtmStepDefinitions {

    private static final String CESAR = "Cesar";

    @When("^Cesar compares the reference information with the ATM information$")
    public void compare() {
        theActorCalled(CESAR).attemptsTo(
                compareATMFiles()
        );
    }

    @Then("^Cesar should see the information is correct$")
    public void shouldSeeTheInformationIsCorrect() {
        theActorInTheSpotlight().should(seeThat(theInformationIsCorrect()));
    }
}
