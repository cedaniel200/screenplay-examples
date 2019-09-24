package com.cedaniel200.example.model;

import static com.cedaniel200.example.model.OperationType.getOperationTypeByKey;

public class Transaction {

    public static final int LENGTH = 27;
    private final String key; // 5
    private final String value; // 12
    private final String cardNumber; // 9
    private final OperationType operation; // 1

    public Transaction(String line) {
        validate(line);
        this.cardNumber = line.substring(0, 9);
        this.value = line.substring(9, 21);
        this.key = line.substring(21, 26);
        this.operation = getOperationTypeByKey(line.substring(26));
    }

    private void validate(String line) {
        if (line == null || line.length() != LENGTH) {
            // TODO lanzar exception
        }
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public OperationType getOperation() {
        return operation;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", operation=" + operation +
                '}';
    }
}
