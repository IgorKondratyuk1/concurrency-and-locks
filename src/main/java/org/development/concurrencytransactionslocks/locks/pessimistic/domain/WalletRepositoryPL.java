package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface WalletRepositoryPL extends JpaRepository<WalletPL, Long> {

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<WalletPL> findById(Long id);
}
