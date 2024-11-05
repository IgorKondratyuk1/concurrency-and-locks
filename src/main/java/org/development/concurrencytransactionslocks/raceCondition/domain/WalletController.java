package org.development.concurrencytransactionslocks.raceCondition.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("WalletControllerRaceCondition")
@RequestMapping("/api/race-condition/wallet")
class WalletController {

    private final WalletService walletService;
    private final PurchService purchService;

    @Autowired
    public WalletController(WalletService walletService, PurchService purchService) {
        this.walletService = walletService;
        this.purchService = purchService;
    }

    @GetMapping("/{id}")
    public WalletRC getWallet(@PathVariable Long id) {
        return this.walletService.getWallet(id);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllData(@PathVariable Long id) {
        WalletRC wallet = this.walletService.getWallet(id);
        List<PurchRC> purches = this.purchService.getPurchase();

        Map data = new HashMap<>();
        data.put("wallet", wallet);
        data.put("purches", purches);
        data.put("purches count", purches.size());

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public WalletRC createWallet() {
        return this.walletService.createWallet(2000);
    }
}
