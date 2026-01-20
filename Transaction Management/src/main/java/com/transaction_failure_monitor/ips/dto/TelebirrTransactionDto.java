package com.transaction_failure_monitor.ips.dto;

import lombok.Data;

@Data
public class TelebirrTransactionDto {
  private   double amount;
    private String account;
    private String beneficiaryMsisdn;
    private String statusTransfer;
    private String statusCancelFr;
}
