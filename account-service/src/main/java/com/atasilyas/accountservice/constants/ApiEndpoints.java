package com.atasilyas.accountservice.constants;

import org.springframework.http.MediaType;

public final class ApiEndpoints {
    public static final String RESPONSE_CONTENTTYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";

    public static final String API_BASE_URL = "/api";
    public static final String ACCOUNT_API = API_BASE_URL + "/account";

    private ApiEndpoints() {

    }
}