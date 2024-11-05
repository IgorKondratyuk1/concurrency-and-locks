package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import lombok.Data;

@Data
public class PurchDto {
    private String name;
    private Integer price;
    private Long walletId;
}
