package org.development.concurrencytransactionslocks.locks.optimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("WalletControllerOptimisticLock")
@RequestMapping("/api/optimistic-lock/wallet")
class WalletController {

    private final WalletService walletService;
    private final PurchService purchService;

    @Autowired
    public WalletController(@Qualifier("WalletServiceOptimisticLock") WalletService walletService, @Qualifier("PurchServiceOptimisticLock") PurchService purchService) {
        this.walletService = walletService;
        this.purchService = purchService;
    }

    @GetMapping("/{id}")
    public WalletOL getWallet(@PathVariable Long id) {
        return this.walletService.getWallet(id);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllData(@PathVariable Long id) {
        WalletOL wallet = this.walletService.getWallet(id);
        List<PurchOL> purches = this.purchService.getPurchase();

        Map data = new HashMap<>();
        data.put("wallet", wallet);
        data.put("purches", purches);
        data.put("purches count", purches.size());

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public WalletOL createWallet() {
        return this.walletService.createWallet(2000);
    }
}
