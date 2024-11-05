package org.development.concurrencytransactionslocks.raceCondition.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepositoryRC extends JpaRepository<WalletRC, Long> {
}
