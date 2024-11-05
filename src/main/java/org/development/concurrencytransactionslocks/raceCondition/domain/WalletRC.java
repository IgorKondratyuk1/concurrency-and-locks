package org.development.concurrencytransactionslocks.raceCondition.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_race_condition")
public class WalletRC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sum")
    Integer sum;

    public WalletRC(Integer sum) {
        this.sum = sum;
    }
}
