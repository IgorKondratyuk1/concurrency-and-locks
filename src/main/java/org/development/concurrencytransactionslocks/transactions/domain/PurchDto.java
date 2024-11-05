package org.development.concurrencytransactionslocks.transactions.domain;

import lombok.Data;

@Data
class PurchDto {
    private String name;
    private Integer price;
    private Long walletId;
}
