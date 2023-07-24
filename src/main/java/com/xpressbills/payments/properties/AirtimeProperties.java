package com.xpressbills.payments.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Getter
@Setter
@ConfigurationProperties(prefix = "airtime")
public class AirtimeProperties {
    private String endpoint;
    private String publicKey;
    private String hmac;

}
