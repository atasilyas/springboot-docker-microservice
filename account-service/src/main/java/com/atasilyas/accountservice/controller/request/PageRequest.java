package com.atasilyas.accountservice.controller.request;

import lombok.Data;

@Data
public class PageRequest {
    private int page;
    private int size;
}
