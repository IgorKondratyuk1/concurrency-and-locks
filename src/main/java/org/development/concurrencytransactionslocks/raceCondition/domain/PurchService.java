package org.development.concurrencytransactionslocks.raceCondition.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PurchServiceRaceCondition")
class PurchService {

    private final WalletRepositoryRC wallerRepository;
    private final PurchRepositoryRC purchRepositoryPurchRaceCondition;

    @Autowired
    public PurchService(PurchRepositoryRC purchRepositoryPurchRaceCondition, WalletRepositoryRC wallerRepository) {
        this.purchRepositoryPurchRaceCondition = purchRepositoryPurchRaceCondition;
        this.wallerRepository = wallerRepository;
    }

    public List<PurchRC> getPurchase() {
        return this.purchRepositoryPurchRaceCondition.findAll();
    }

    public PurchRC doPurch(PurchDto purchDto) {
        WalletRC wallet = this.wallerRepository.findById(purchDto.getWalletId()).orElseThrow(() -> new RuntimeException("no wallet"));

        if (wallet.getSum() < purchDto.getPrice()) {
            throw new RuntimeException("No money for purch " + purchDto.getPrice() + " in wallet only: " + wallet.getSum());
        }
        Integer sum = wallet.getSum() - purchDto.getPrice();
        wallet.setSum(sum);
        this.wallerRepository.save(wallet);

        return this.purchRepositoryPurchRaceCondition.save(new PurchRC(purchDto.getName(), purchDto.getPrice(), purchDto.getWalletId()));
    }
}
