package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface PurchRepositoryPL extends JpaRepository<PurchPL, Long> {
}
