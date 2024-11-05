package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_pessimistic_lock")
public class WalletPL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sum")
    Integer sum;

    public WalletPL(Integer sum) {
        this.sum = sum;
    }
}
