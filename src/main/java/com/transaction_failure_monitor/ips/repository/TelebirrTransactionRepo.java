package com.transaction_failure_monitor.ips.repository;

import com.transaction_failure_monitor.ips.entity.TelebirrTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TelebirrTransactionRepo extends JpaRepository<TelebirrTransaction, Integer> {

    List<TelebirrTransaction> findByTodayDate(String date);
    Optional<TelebirrTransaction> findByTransactionIdTelebirr(String transactionId);

}
