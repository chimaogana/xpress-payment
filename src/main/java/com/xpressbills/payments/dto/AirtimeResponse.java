package com.xpressbills.payments.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AirtimeResponse {
    private String requestId;
    private String referenceId;
    private String responseCode;
    private String responseMessage;
    private Object data;






}