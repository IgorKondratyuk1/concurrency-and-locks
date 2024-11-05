package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_optimistic_lock")
public class WalletOL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sum")
    Integer sum;

    @Version
    @Column(name = "version")
    Integer version;

    public WalletOL(Integer sum) {
        this.sum = sum;
    }
}
