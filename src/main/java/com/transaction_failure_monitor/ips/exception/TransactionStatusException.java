package com.transaction_failure_monitor.ips.exception;

public class TransactionStatusException extends RuntimeException {
    public TransactionStatusException(String message) {
        super(message);
    }
}
