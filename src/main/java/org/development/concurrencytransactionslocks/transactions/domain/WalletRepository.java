package org.development.concurrencytransactionslocks.transactions.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface WalletRepository extends JpaRepository<Wallet, Long> {
}
