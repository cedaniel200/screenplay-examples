package com.cedaniel200.example.exception;

public class MismatchedTransactionsError extends AssertionError {

    private static final String MESSAGE_ERROR_FORMAT = "The mismatched transactions are shown below:\n%s";

    public MismatchedTransactionsError(String stringOfmismatchedTransactions) {
        super(String.format(MESSAGE_ERROR_FORMAT, stringOfmismatchedTransactions));
    }

}
