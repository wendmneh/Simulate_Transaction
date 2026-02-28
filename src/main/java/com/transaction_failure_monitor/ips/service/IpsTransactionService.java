package com.transaction_failure_monitor.ips.service;

import com.transaction_failure_monitor.ips.dto.TransactionDto;
import com.transaction_failure_monitor.ips.entity.IpsTransactions;


public interface IpsTransactionService {

    IpsTransactions saveIPSTransaction(TransactionDto dto);

}
