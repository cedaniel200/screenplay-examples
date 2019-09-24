package com.cedaniel200.example.model;

import java.util.Arrays;

public enum OperationType {
    RETIREMENT("R"),
    CONSIGNMENT("C");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static OperationType getOperationTypeByKey(String key) {
        return Arrays.stream(values())
                .filter(operationType -> operationType.operation.equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The operation " + key + "not found"));
    }
}
