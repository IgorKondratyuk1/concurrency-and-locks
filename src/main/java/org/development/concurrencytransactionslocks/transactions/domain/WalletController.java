package org.development.concurrencytransactionslocks.transactions.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transaction/wallet")
class WalletController {

    private final WalletService walletService;
    private final PurchService purchService;

    @Autowired
    public WalletController(WalletService walletService, PurchService purchService) {
        this.walletService = walletService;
        this.purchService = purchService;
    }

    @GetMapping("/{id}")
    public Wallet getWallet(@PathVariable Long id) {
        return this.walletService.getWallet(id);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllData(@PathVariable Long id) {
        Wallet wallet = this.walletService.getWallet(id);
        List<Purch> purches = this.purchService.getPurchase();

        Map data = new HashMap<>();
        data.put("wallet", wallet);
        data.put("purches", purches);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public Wallet createWallet() {
        return this.walletService.createWallet(200);
    }
}
