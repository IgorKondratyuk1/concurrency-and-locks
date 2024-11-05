package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WalletServiceOptimisticLock")
class WalletService {
    private final WalletRepositoryOL wallerRepository;

    @Autowired
    public WalletService(WalletRepositoryOL wallerRepository) {
        this.wallerRepository = wallerRepository;
    }

    public WalletOL getWallet(Long id) {
        return this.wallerRepository.findById(id).orElseThrow(() -> new RuntimeException("no wallet"));
    }

    public WalletOL createWallet(Integer sum) {
        return this.wallerRepository.save(new WalletOL(sum));
    }
}
