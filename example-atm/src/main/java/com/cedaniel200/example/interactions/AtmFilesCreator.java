package com.cedaniel200.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AtmFilesCreator implements Interaction {

    static final String ATM_FILE_NAME = "atm.txt";
    private List<String> lines;

    public AtmFilesCreator() {
        this.lines = new ArrayList<>();
        lines.add("3");
        lines.add("12345678900000009000000001C");
        lines.add("98765432100000010000000002R");
        lines.add("12345678900000002000000003R");
    }

    @Override
    @Step("{0} creates the ATM files")
    public <T extends Actor> void performAs(T actor) {
        File atm = FileUtils.getFile(ATM_FILE_NAME);
        try {
            createFileIfNotExist(atm);
        } catch (IOException e) {
            // TODO lanzar exception
        }
    }

    private void createFileIfNotExist(File atm) throws IOException {
        if (!atm.exists()) {
            FileUtils.touch(atm);
            FileUtils.writeLines(atm, lines);
        }
    }

    public static AtmFilesCreator createAtmFile() {
        return instrumented(AtmFilesCreator.class);
    }
}
