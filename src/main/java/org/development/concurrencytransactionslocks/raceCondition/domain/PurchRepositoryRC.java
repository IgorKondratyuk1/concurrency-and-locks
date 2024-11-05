package org.development.concurrencytransactionslocks.raceCondition.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface PurchRepositoryRC extends JpaRepository<PurchRC, Long> {
}
