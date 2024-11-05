package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("WalletControllerPessimisticLock")
@RequestMapping("/api/pessimistic-lock/wallet")
class WalletController {

    private final WalletService walletService;
    private final PurchService purchService;

    @Autowired
    public WalletController(@Qualifier("WalletServicePessimisticLock") WalletService walletService, @Qualifier("PurchServicePessimisticLock") PurchService purchService) {
        this.walletService = walletService;
        this.purchService = purchService;
    }

    @GetMapping("/{id}")
    public WalletPL getWallet(@PathVariable Long id) {
        return this.walletService.getWallet(id);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllData(@PathVariable Long id) {
        WalletPL wallet = this.walletService.getWallet(id);
        List<PurchPL> purches = this.purchService.getPurchase();

        Map data = new HashMap<>();
        data.put("wallet", wallet);
        data.put("purches", purches);
        data.put("purches count", purches.size());

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public WalletPL createWallet() {
        return this.walletService.createWallet(2000);
    }
}
