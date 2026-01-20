package com.transaction_failure_monitor.ips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class IpsApplication {
    static void main(String[] args) {
        SpringApplication.run(IpsApplication.class, args);
    }

}
