package com.xpressbills.payments.service;
import com.xpressbills.payments.dto.AirtimeResponse;
import com.xpressbills.payments.properties.AirtimeProperties;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// AirtimeService.java
@Service
@RequiredArgsConstructor
public class AirtimeService {
    private final RestTemplate restTemplate;
    private final AirtimeProperties airtimeProperties;

//    @Autowired
//    public AirtimeService(RestTemplate restTemplate, AirtimeProperties airtimeProperties) {
//        this.restTemplate = restTemplate;
//        this.airtimeProperties = airtimeProperties;
//    }

    public AirtimeResponse purchaseAirtime(String phoneNumber, int amount) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + airtimeProperties.getPublicKey());
        headers.set("PaymentHash", airtimeProperties.getHmac());
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("requestId", UUID.randomUUID().toString());
        requestPayload.put("uniqueCode", "MTN_24207");
        Map<String, Object> details = new HashMap<>();
        details.put("phoneNumber", phoneNumber);
        details.put("amount", amount);
        requestPayload.put("details", details);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestPayload, headers);
        ResponseEntity<AirtimeResponse> responseEntity = restTemplate.exchange(
                airtimeProperties.getEndpoint(),
                HttpMethod.POST,
                requestEntity,
                AirtimeResponse.class
        );

        return responseEntity.getBody();
    }
}
