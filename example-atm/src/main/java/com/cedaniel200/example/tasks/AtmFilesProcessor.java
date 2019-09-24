package com.cedaniel200.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static com.cedaniel200.example.interactions.AtmFilesCreator.createAtmFile;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AtmFilesProcessor implements Task {

    @Override
    @Step("{0} processes ATM files")
    public <T extends Actor> void performAs(T actor) {
        // TODO se realia conexion SSH
        // TODO se ejecuta el comando para el procesmiento de los archivos
        // TODO se verifica que se hayan creado los archivos, en caso contrario se lanza una excepcion
        // Por el momento se simulará la creación de un archivo
        actor.attemptsTo(createAtmFile());
    }

    public static AtmFilesProcessor processAtmFiles() {
        return instrumented(AtmFilesProcessor.class);
    }
}
