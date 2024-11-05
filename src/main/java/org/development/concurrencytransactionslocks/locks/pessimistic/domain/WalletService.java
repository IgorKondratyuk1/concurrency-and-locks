package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("WalletServicePessimisticLock")
@Transactional
class WalletService {
    private final WalletRepositoryPL wallerRepository;

    @Autowired
    public WalletService(WalletRepositoryPL wallerRepository) {
        this.wallerRepository = wallerRepository;
    }

    public WalletPL getWallet(Long id) {
        return this.wallerRepository.findById(id).orElseThrow(() -> new RuntimeException("no wallet"));
    }

    public WalletPL createWallet(Integer sum) {
        return this.wallerRepository.save(new WalletPL(sum));
    }
}
