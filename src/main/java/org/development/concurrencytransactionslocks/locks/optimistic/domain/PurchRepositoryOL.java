package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface PurchRepositoryOL extends JpaRepository<PurchOL, Long> {
}
