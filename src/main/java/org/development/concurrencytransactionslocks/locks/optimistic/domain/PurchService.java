package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PurchServiceOptimisticLock")
@Transactional
class PurchService {

    private final WalletRepositoryOL wallerRepository;
    private final PurchRepositoryOL purchRepositoryOL;

    @Autowired
    public PurchService(PurchRepositoryOL purchRepositoryOL, WalletRepositoryOL wallerRepository) {
        this.purchRepositoryOL = purchRepositoryOL;
        this.wallerRepository = wallerRepository;
    }

    public List<PurchOL> getPurchase() {
        return this.purchRepositoryOL.findAll();
    }

    public PurchOL doPurch(PurchDto purchDto) {
        System.out.println("PurchServiceOptimisticLock doPurch");
        WalletOL wallet = this.wallerRepository.findById(purchDto.getWalletId()).orElseThrow(() -> new RuntimeException("no wallet"));

        if (wallet.getSum() < purchDto.getPrice()) {
            throw new RuntimeException("No money for purch " + purchDto.getPrice() + " in wallet only: " + wallet.getSum());
        }
        Integer sum = wallet.getSum() - purchDto.getPrice();
        wallet.setSum(sum);
        this.wallerRepository.save(wallet);

        return this.purchRepositoryOL.save(new PurchOL(purchDto.getName(), purchDto.getPrice(), purchDto.getWalletId()));
    }
}
