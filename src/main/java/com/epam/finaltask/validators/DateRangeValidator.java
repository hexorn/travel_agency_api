package com.epam.finaltask.validators;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, VoucherCreateRequestDto> {

    @Override
    public boolean isValid(VoucherCreateRequestDto dto, ConstraintValidatorContext context) {
        if (Objects.isNull(dto.getArrivalDate()) || Objects.isNull(dto.getEvictionDate())) {
            return true;
        }
        return dto.getEvictionDate().isAfter(dto.getArrivalDate());
    }
}