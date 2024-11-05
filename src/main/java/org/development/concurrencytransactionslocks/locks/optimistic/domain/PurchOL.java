package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purch_optimistic_lock")
class PurchOL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sum")
    Integer price;

    @Column(name = "name")
    String name;

    @Column(name = "wallet_id")
    Long walletId;

    public PurchOL(String name, Integer price, Long walletId) {
        this.name = name;
        this.price = price;
        this.walletId = walletId;
    }
}
