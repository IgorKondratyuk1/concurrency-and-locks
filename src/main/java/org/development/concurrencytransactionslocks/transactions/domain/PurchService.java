package org.development.concurrencytransactionslocks.transactions.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
class PurchService {

    private final WalletService walletService;
    private final WalletRepository wallerRepository;
    private final PurchRepository purchRepository;

    @Autowired
    public PurchService(WalletService walletService, PurchRepository purchRepository, WalletRepository wallerRepository) {
        this.walletService = walletService;
        this.purchRepository = purchRepository;
        this.wallerRepository = wallerRepository;
    }

    public List<Purch> getPurchase() {
        return this.purchRepository.findAll();
    }



    public Purch doPurchNotTransactional(PurchDto purchDto) {
        Wallet wallet = this.wallerRepository.findById(purchDto.getWalletId()).orElseThrow(() -> new RuntimeException("no wallet"));

        if (wallet.getSum() < purchDto.getPrice()) {
            throw new RuntimeException("No money for purch " + purchDto.getPrice() + " in wallet only : " + wallet.getSum());
        }
        Integer sum = wallet.getSum() - purchDto.getPrice();
        wallet.setSum(sum);
        this.wallerRepository.save(wallet);

        if (true) throw new RuntimeException("Some not transactional error");

        return this.purchRepository.save(new Purch(purchDto.getName(), purchDto.getPrice(), purchDto.getWalletId()));
    }

    @Transactional
    public Purch doPurchTransactional(PurchDto purchDto) {
        Wallet wallet = this.wallerRepository.findById(purchDto.getWalletId()).orElseThrow(() -> new RuntimeException("no wallet"));

        if (wallet.getSum() < purchDto.getPrice()) {
            throw new RuntimeException("No money for purch " + purchDto.getPrice() + " in wallet only : " + wallet.getSum());
        }
        Integer sum = wallet.getSum() - purchDto.getPrice();
        wallet.setSum(sum);
        this.wallerRepository.save(wallet);

        if (true) throw new RuntimeException("Some transactional error");

        return this.purchRepository.save(new Purch(purchDto.getName(), purchDto.getPrice(), purchDto.getWalletId()));
    }
}
