package com.transaction_failure_monitor.ips.service;

import com.transaction_failure_monitor.ips.dto.TelebirrTransactionDto;
import com.transaction_failure_monitor.ips.entity.TelebirrTransaction;

public interface TelebirTransactionService {
    TelebirrTransaction saveTelebirrTransaction(TelebirrTransactionDto dto);
}
