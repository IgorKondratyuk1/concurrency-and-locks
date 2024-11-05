package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purch_pessimistic_lock")
class PurchPL {

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

    public PurchPL(String name, Integer price, Long walletId) {
        this.name = name;
        this.price = price;
        this.walletId = walletId;
    }
}
