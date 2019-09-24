package com.cedaniel200.example.question;

import com.cedaniel200.example.exception.MismatchedTransactionsError;
import com.cedaniel200.example.model.ComparisonFailed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.util.List;
import java.util.Objects;

import static com.cedaniel200.example.interactions.AtmFilesComparator.MISMATCHED_TRANSACTIONS;

@Subject("the information is correct")
public class MismatchedTransactionReviewer implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        List<ComparisonFailed> mismatchedTransactions = actor.recall(MISMATCHED_TRANSACTIONS);
        verifyList(mismatchedTransactions);
        return mismatchedTransactions.isEmpty();
    }

    private void verifyList(List<ComparisonFailed> mismatchedTransactions) {
        if (!mismatchedTransactions.isEmpty()) {
            String stringOfMismatchedTransactions = getStringOfMismatchedTransactions(mismatchedTransactions);
            throw new MismatchedTransactionsError(stringOfMismatchedTransactions);
        }
    }

    private String getStringOfMismatchedTransactions(List<ComparisonFailed> mismatchedTransactions) {
        return mismatchedTransactions.stream()
                .map(Objects::toString)
                .reduce((s, s2) -> s += "\n" + s2)
                .orElse("");
    }

    public static MismatchedTransactionReviewer theInformationIsCorrect() {
        return new MismatchedTransactionReviewer();
    }
}
