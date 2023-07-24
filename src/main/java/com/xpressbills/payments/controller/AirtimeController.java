package com.xpressbills.payments.controller;
import com.xpressbills.payments.dto.AirtimeResponse;
import com.xpressbills.payments.service.AirtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airtime")
public class AirtimeController {
    private final AirtimeService airtimeService;

    @Autowired
    public AirtimeController(AirtimeService airtimeService) {
        this.airtimeService = airtimeService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<AirtimeResponse> purchaseAirtime(@RequestParam String phoneNumber, @RequestParam int amount) {
        AirtimeResponse response = airtimeService.purchaseAirtime(phoneNumber, amount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}