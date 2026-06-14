package com.epam.finaltask.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponseWrapper<T> {
    private T payload;
    private String statusCode;
    private String statusMessage;
}
