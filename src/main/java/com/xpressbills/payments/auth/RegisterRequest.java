package com.xpressbills.payments.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}
