package com.cedaniel200.example.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.cedaniel200.example.interactions.AtmFilesLoader.loadAtmFile;
import static com.cedaniel200.example.tasks.AtmFilesProcessor.processAtmFiles;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class StageSetting {

    private static final String AUTHENTIC = "Authentic ATM";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Authentic ATM generated the files")
    public void generateFiles(){
        theActorCalled(AUTHENTIC).wasAbleTo(
                processAtmFiles(),
                loadAtmFile()
        );
    }

}
