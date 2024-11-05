package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepositoryOL extends JpaRepository<WalletOL, Long> {
}
