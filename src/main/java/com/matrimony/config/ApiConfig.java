package com.matrimony.config;

import org.springframework.beans.factory.annotation.Value;

public class ApiConfig {

    @Value("${microservices.common.endpoint}")
    public String microservicesCommonEndpoint;

}
