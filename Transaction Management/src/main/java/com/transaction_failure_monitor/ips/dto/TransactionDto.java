package com.transaction_failure_monitor.ips.dto;

import com.transaction_failure_monitor.ips.util.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "TransactionDto", description = "Data transfer object for creating or updating a transaction")
public class TransactionDto {

    @Schema(description = "Debtor account number", example = "DE1234567890", required = true)
    private String debtorAccountNo;

    @Schema(description = "Creditor account number", example = "CR9876543210", required = true)
    private String creditorAccountNo;

    @Schema(description = "Transaction amount", example = "1500.50", required = true)
    private double amount;

    @Schema(description = "Debtor bank BIC code", example = "DEUTDEFF", required = true)
    private String debtorBankBic;

    @Schema(description = "Creditor bank BIC code", example = "CRDUBEBB", required = true)
    private String creditorBankBic;

    @Schema(description = "Status of the transaction", example = "FAILED", required = true)
    private String transactionStatus;

    @Schema(description = "Transfer reference number", example = "TRX123456789")
    private String transferRefNo;

    @Schema(description = "Alternative creditor account holder name", example = "John Doe")
    private String creditorAccountHolderNameAlt;

    @Schema(description = "Debtor account holder name", example = "Jane Smith")
    private String debitorAccountHolderName;


}
