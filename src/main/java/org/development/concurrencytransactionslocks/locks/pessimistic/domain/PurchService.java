package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("PurchServicePessimisticLock")
@Transactional
class PurchService {

    private final WalletRepositoryPL walletRepository;
    private final PurchRepositoryPL purchRepositoryPL;

    @Autowired
    public PurchService(PurchRepositoryPL purchRepositoryPL, WalletRepositoryPL walletRepository) {
        this.purchRepositoryPL = purchRepositoryPL;
        this.walletRepository = walletRepository;
    }

    public List<PurchPL> getPurchase() {
        return this.purchRepositoryPL.findAll();
    }

    public PurchPL doPurch(PurchDto purchDto) {
        System.out.println("PurchServicePessimisticLock doPurch");
        WalletPL wallet = this.walletRepository.findById(purchDto.getWalletId()).orElseThrow(() -> new RuntimeException("Empty optional walletPLOptional"));

        if (wallet.getSum() < purchDto.getPrice()) {
            throw new RuntimeException("No money for purch " + purchDto.getPrice() + " in wallet only: " + wallet.getSum());
        }

        Integer sum = wallet.getSum() - purchDto.getPrice();
        wallet.setSum(sum);
        this.walletRepository.save(wallet);

        return this.purchRepositoryPL.save(new PurchPL(purchDto.getName(), purchDto.getPrice(), purchDto.getWalletId()));
    }
}
