package org.development.concurrencytransactionslocks.transactions.domain;

import org.development.concurrencytransactionslocks.transactions.domain.Purch;
import org.springframework.data.jpa.repository.JpaRepository;

interface PurchRepository extends JpaRepository<Purch, Long> {
}
