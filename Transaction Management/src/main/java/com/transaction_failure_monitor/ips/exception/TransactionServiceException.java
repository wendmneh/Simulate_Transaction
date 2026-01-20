package com.transaction_failure_monitor.ips.exception;

public class TransactionServiceException extends RuntimeException {
    public TransactionServiceException(String message) {
        super(message);
    }
}
