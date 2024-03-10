package com.zb.mission.controller;

import com.zb.mission.entity.Partner;
import com.zb.mission.service.PartnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerservice) {
        this.partnerService = partnerservice;
    }

    @PostMapping
    public ResponseEntity<Partner> registerPartner(@RequestBody Partner partner) {
        return ResponseEntity.ok(partnerService.registerPartner(partner));
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getAllPartners() {
        return ResponseEntity.ok(partnerService.getAllPartners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable int id) {
        return ResponseEntity.ok(partnerService.getPartnerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> leavePartner(@PathVariable int id) {
        partnerService.leavePartner(id);
        return ResponseEntity.noContent().build();
    }
}
