package com.counties.kenya.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyApiResponse {
    private String description;
    private Object data;

    public MyApiResponse() {
    }

    public MyApiResponse(String description) {
        this.description = description;
    }

    public MyApiResponse(String description, Object data) {
        this.description = description;
        this.data = data;
    }
}
