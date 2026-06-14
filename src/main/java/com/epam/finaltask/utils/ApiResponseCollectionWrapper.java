package com.epam.finaltask.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponseCollectionWrapper<T> {
    private T results;
}
