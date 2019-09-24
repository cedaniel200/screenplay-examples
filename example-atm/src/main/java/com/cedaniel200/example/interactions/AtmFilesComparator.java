package com.cedaniel200.example.interactions;

import com.cedaniel200.example.model.ComparisonFailed;
import com.cedaniel200.example.model.Transaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.cedaniel200.example.interactions.AtmFilesLoader.atm_data;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AtmFilesComparator implements Interaction {

    public static final String MISMATCHED_TRANSACTIONS = "mismatchedTransactions";
    private List<Transaction> transactions;
    private List<ComparisonFailed> mismatchedTransactions;

    public AtmFilesComparator() {
        /* Simula la lista de datos que se podria obtener de un excel
         * o Json o cualquier otro archivo para realizar la comparacion con
         * los datos generados por el procesmientos de los archivos de ATM
         */
        mismatchedTransactions = new ArrayList<>();
        transactions = new ArrayList<>();
        transactions.add(new Transaction("12345678800000009000000001C"));
        transactions.add(new Transaction("98765432100000010000000002R"));
        transactions.add(new Transaction("12345678900000002000000003R"));
    }

    @Override
    @Step("{0} compares the files of atm")
    public <T extends Actor> void performAs(T actor) {
        transactions.forEach(this::compare);
        actor.remember(MISMATCHED_TRANSACTIONS, mismatchedTransactions);
    }


    private void compare(Transaction transaction) {
        Transaction transactionFromATM = atm_data.get(transaction.getKey());
        verifyIfExist(transactionFromATM);
        compareTransactions(transaction, transactionFromATM);
    }

    private void verifyIfExist(Transaction transactionFromATM) {
        if (transactionFromATM == null) {
            // TODO lanzar exception
        }
    }

    private void compareTransactions(Transaction transaction, Transaction transactionFromATM) {
        if (!transactionFromATM.toString().equals(transaction.toString())) {
            mismatchedTransactions.add(new ComparisonFailed(transaction, transactionFromATM));
        }
    }

    public static AtmFilesComparator compareATMFiles() {
        return instrumented(AtmFilesComparator.class);
    }

}
