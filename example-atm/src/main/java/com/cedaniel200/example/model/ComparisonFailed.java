package com.cedaniel200.example.model;

public class ComparisonFailed {
    private final Transaction referenceTransaction;
    private final Transaction transactionFromATM;

    public ComparisonFailed(Transaction referenceTransaction, Transaction transactionFromATM) {
        this.referenceTransaction = referenceTransaction;
        this.transactionFromATM = transactionFromATM;
    }

    public Transaction getReferenceTransaction() {
        return referenceTransaction;
    }

    public Transaction getTransactionFromATM() {
        return transactionFromATM;
    }

    @Override
    public String toString() {
        return "ComparisonFailed{" +
                "key='" + referenceTransaction.getKey() + '\'' + " - '" + transactionFromATM.getKey() + '\'' +
                ", value='" + referenceTransaction.getValue() + '\'' + " - '" + transactionFromATM.getValue() + '\'' +
                ", cardNumber='" + referenceTransaction.getCardNumber() + '\'' + " - '" + transactionFromATM.getCardNumber() + '\'' +
                ", operation='" + referenceTransaction.getOperation() + '\'' + " - '" + transactionFromATM.getOperation() + '\'' +
                '}';
    }
}
