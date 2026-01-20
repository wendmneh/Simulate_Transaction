package com.transaction_failure_monitor.ips.repository;


import com.transaction_failure_monitor.ips.entity.IpsTransactions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IpsTransactionRepo extends JpaRepository<IpsTransactions, Long> {


}
