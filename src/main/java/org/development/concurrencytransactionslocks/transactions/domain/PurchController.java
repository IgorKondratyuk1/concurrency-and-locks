package org.development.concurrencytransactionslocks.transactions.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction/purchase")
class PurchController {

    private final PurchService purchService;

    @Autowired
    public PurchController(PurchService purchService) {
        this.purchService = purchService;
    }

    @PostMapping("/not-transactional")
    public Purch doPurchNotTransactional(@RequestBody PurchDto purchDto) {
        return this.purchService.doPurchNotTransactional(purchDto);
    }

    @PostMapping("/transactional")
    public Purch doPurchTransactional(@RequestBody PurchDto purchDto) {
        return this.purchService.doPurchTransactional(purchDto);
    }
}
