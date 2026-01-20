package com.transaction_failure_monitor.ips.serviceImpl;

import com.transaction_failure_monitor.ips.dto.RabbitMQMessageDTO;
import com.transaction_failure_monitor.ips.dto.TransactionDto;
import com.transaction_failure_monitor.ips.entity.IpsTransactions;
import com.transaction_failure_monitor.ips.exception.TransactionServiceException;
import com.transaction_failure_monitor.ips.repository.IpsTransactionRepo;
import com.transaction_failure_monitor.ips.service.IpsTransactionService;
import com.transaction_failure_monitor.ips.util.IpsTransactionStatus;
import com.transaction_failure_monitor.ips.util.TransactionType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class IpsTransactionServiceImpl implements IpsTransactionService {
    private final IpsTransactionRepo ipsTransactionRepo;

    private final Logger logger = LoggerFactory.getLogger(IpsTransactionServiceImpl.class);


    @Transactional
    @Override
    public IpsTransactions saveIPSTransaction(TransactionDto dto) {

        IpsTransactions tx = ipsTransactionSavingLogic(dto);

        TransactionType transactionType = TransactionType.IPS;
        RabbitMQMessageDTO message = new RabbitMQMessageDTO(tx.getTransid(), transactionType.name(), tx.getAmount());



        return tx;
    }



    public IpsTransactions ipsTransactionSavingLogic(TransactionDto dto) {
        LocalDateTime now = LocalDateTime.now();
        IpsTransactions tx = new IpsTransactions();
        String transactionId = "WTETTA-" + UUID.randomUUID();
        tx.setId(UUID.randomUUID().toString());
        tx.setTransid(transactionId);
        tx.setDebtorAccountNo(dto.getDebtorAccountNo());
        tx.setCreditorAccountNo(dto.getCreditorAccountNo());
        tx.setAmount(String.valueOf(dto.getAmount()));
        tx.setDebtorBankBic(dto.getDebtorBankBic());
        tx.setCreditorBankBic(dto.getCreditorBankBic());
        tx.setTransactionStatus(String.valueOf(IpsTransactionStatus.valueOf(dto.getTransactionStatus())));
        tx.setTransferRefNo(dto.getTransferRefNo());
        tx.setCreditorAccountHolderName2(dto.getCreditorAccountHolderNameAlt());
        tx.setDebitorAccountHolderName(dto.getDebitorAccountHolderName());
        tx.setCreatedDate(String.valueOf(now));
        tx.setStatusUpdatedDate(String.valueOf(now));
        tx.setTodayDate(String.valueOf(now.toLocalDate()));
        return ipsTransactionRepo.save(tx);
    }


    public Page<IpsTransactions> getAllTransactions(Pageable pageable) {
        Page<IpsTransactions> response;
        try {
            response = ipsTransactionRepo.findAll(pageable);
        } catch (Exception e) {
            throw new TransactionServiceException(e.getMessage());
        }
        return response;
    }

}
