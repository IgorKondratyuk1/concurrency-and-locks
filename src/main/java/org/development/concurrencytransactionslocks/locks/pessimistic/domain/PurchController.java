package org.development.concurrencytransactionslocks.locks.pessimistic.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PurchControllerPessimisticLock")
@RequestMapping("/api/pessimistic-lock/purchase")
class PurchController {

    private final PurchService purchService;

    @Autowired
    public PurchController(@Qualifier("PurchServicePessimisticLock") PurchService purchService) {
        this.purchService = purchService;
    }

    @PostMapping("")
    public PurchPL doPurch(@RequestBody PurchDto purchDto) {
        return this.purchService.doPurch(purchDto);
    }
}
