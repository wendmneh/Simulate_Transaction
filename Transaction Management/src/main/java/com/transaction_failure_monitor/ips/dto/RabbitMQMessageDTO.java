package com.transaction_failure_monitor.ips.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMQMessageDTO {
    private String transactionId;
    private String transactionType;
    private String amount;

}
