package com.transaction_failure_monitor.ips.serviceImpl;

import com.transaction_failure_monitor.ips.dto.RabbitMQMessageDTO;
import com.transaction_failure_monitor.ips.dto.TelebirrTransactionDto;
import com.transaction_failure_monitor.ips.entity.TelebirrTransaction;
import com.transaction_failure_monitor.ips.exception.TransactionServiceException;
import com.transaction_failure_monitor.ips.repository.TelebirrTransactionRepo;
import com.transaction_failure_monitor.ips.service.TelebirTransactionService;
import com.transaction_failure_monitor.ips.util.TransactionType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelebirTransactionServiceImpl implements TelebirTransactionService {
    private final TelebirrTransactionRepo telebirrTransactionRepo;
    private final Logger logger = LoggerFactory.getLogger(IpsTransactionServiceImpl.class);



    @Override
    public TelebirrTransaction saveTelebirrTransaction(TelebirrTransactionDto dto) {

        TelebirrTransaction tx = saveTelebirrTransactionLogic(dto);

        return tx;
    }

    public TelebirrTransaction saveTelebirrTransactionLogic(TelebirrTransactionDto dto) {
        LocalDateTime now = LocalDateTime.now();
        TelebirrTransaction tx = new TelebirrTransaction();
        tx.setAmount(dto.getAmount());
        tx.setBranch("0072");
        tx.setAccount(dto.getAccount());
        tx.setCurrency("ETB");
        tx.setCurrencyAlpha("ETB");
        tx.setBeneficiaryMsisdn(dto.getBeneficiaryMsisdn());
        tx.setEventNo(UUID.randomUUID().toString());
        tx.setTransactionIdTelebirr(UUID.randomUUID().toString());
        tx.setStatusTransfer(dto.getStatusTransfer());
        tx.setTransferRefNo(UUID.randomUUID().toString());
        tx.setStatusCancelFr(dto.getStatusCancelFr());
        tx.setTimestamp(String.valueOf(now));
        tx.setTodayDate(now.toLocalDate().toString());
        return telebirrTransactionRepo.save(tx);
    }


    public Page<TelebirrTransaction> getAllTelebirrTransactions(Pageable pageable) {
        Page<TelebirrTransaction> response;
        try {
            response = telebirrTransactionRepo.findAll(pageable);
        } catch (Exception e) {
            throw new TransactionServiceException(e.getMessage());
        }
        return response;
    }

}
