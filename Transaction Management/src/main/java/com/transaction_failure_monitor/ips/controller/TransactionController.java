package com.transaction_failure_monitor.ips.controller;

import com.transaction_failure_monitor.ips.dto.TelebirrTransactionDto;
import com.transaction_failure_monitor.ips.dto.TransactionDto;
import com.transaction_failure_monitor.ips.entity.IpsTransactions;
import com.transaction_failure_monitor.ips.entity.TelebirrTransaction;
import com.transaction_failure_monitor.ips.service.IpsTransactionService;
import com.transaction_failure_monitor.ips.service.TelebirTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "IpsTransactions", description = "Endpoints to create and fetch transactions")
public class TransactionController {

    private final IpsTransactionService ipsTransactionService;
    private final TelebirTransactionService  telebirTransactionService;



    //  Save Transaction
    @Operation(summary = "Save a new transaction", description = "Creates a new transaction record")
    @SecurityRequirement(name = "bearerAuth")

    @PostMapping("/transaction/ips")
    public ResponseEntity<IpsTransactions> saveIpsTransaction(
            @Parameter(description = "Transaction details to save", required = true)
            @RequestBody TransactionDto dto
    ) {
        return new ResponseEntity<>(ipsTransactionService.saveIPSTransaction(dto), HttpStatus.CREATED);
    }


    @PostMapping("/transaction/telebirr")
    public ResponseEntity<TelebirrTransaction> saveTelebirrTransaction(
            @Parameter(description = "Transaction details to save", required = true)
            @RequestBody TelebirrTransactionDto dto
    ) {
        return new ResponseEntity<>(telebirTransactionService.saveTelebirrTransaction(dto), HttpStatus.CREATED);
    }


}
