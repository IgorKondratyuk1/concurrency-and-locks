package org.development.concurrencytransactionslocks.raceCondition.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PurchControllerRaceCondition")
@RequestMapping("/api/race-condition/purchase")
class PurchController {

    private final PurchService purchService;

    @Autowired
    public PurchController(PurchService purchService) {
        this.purchService = purchService;
    }

    @PostMapping("")
    public PurchRC doPurch(@RequestBody PurchDto purchDto) {
        return this.purchService.doPurch(purchDto);
    }
}
