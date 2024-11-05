package org.development.concurrencytransactionslocks.transactions.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class WalletService {
    private final WalletRepository wallerRepository;

    @Autowired
    public WalletService(WalletRepository wallerRepository) {
        this.wallerRepository = wallerRepository;
    }

    public Wallet getWallet(Long id) {
        return this.wallerRepository.findById(id).orElseThrow(() -> new RuntimeException("no wallet"));
    }

    public Wallet createWallet(Integer sum) {
        return this.wallerRepository.save(new Wallet(sum));
    }
}
