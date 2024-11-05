package org.development.concurrencytransactionslocks.raceCondition.domain;

import lombok.Data;

@Data
public class PurchDto {
    private String name;
    private Integer price;
    private Long walletId;
}
