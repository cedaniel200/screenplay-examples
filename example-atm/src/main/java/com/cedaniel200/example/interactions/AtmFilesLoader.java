package com.cedaniel200.example.interactions;

import com.cedaniel200.example.model.Transaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import static com.cedaniel200.example.interactions.AtmFilesCreator.ATM_FILE_NAME;
import static java.util.stream.Collectors.toMap;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.apache.commons.io.FileUtils.getFile;

public class AtmFilesLoader implements Interaction {

    static HashMap<String, Transaction> atm_data;

    @Override
    @Step("{0} loads the ATM files")
    public <T extends Actor> void performAs(T actor) {
        try {
            List<String> lines = getLines();
            atm_data = (HashMap<String, Transaction>) lines.parallelStream()
                    .filter(this::isTransaction)
                    .map(this::toTransaction)
                    .collect(toMap(Transaction::getKey, t -> t));
        } catch (IOException e) {
            // TODO lanzar exception
        }
    }

    private List<String> getLines() throws IOException {
        return FileUtils.readLines(getFile(ATM_FILE_NAME), StandardCharsets.UTF_8);
    }

    private boolean isTransaction(String line) {
        return line.length() == Transaction.LENGTH;
    }

    private Transaction toTransaction(String line) {
        return new Transaction(line);
    }

    public static AtmFilesLoader loadAtmFile() {
        return instrumented(AtmFilesLoader.class);
    }
}
