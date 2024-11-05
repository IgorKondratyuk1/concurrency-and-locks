package org.development.concurrencytransactionslocks.raceCondition.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WalletServiceRaceCondition")
class WalletService {
    private final WalletRepositoryRC wallerRepository;

    @Autowired
    public WalletService(WalletRepositoryRC wallerRepository) {
        this.wallerRepository = wallerRepository;
    }

    public WalletRC getWallet(Long id) {
        return this.wallerRepository.findById(id).orElseThrow(() -> new RuntimeException("no wallet"));
    }

    public WalletRC createWallet(Integer sum) {
        return this.wallerRepository.save(new WalletRC(sum));
    }
}
