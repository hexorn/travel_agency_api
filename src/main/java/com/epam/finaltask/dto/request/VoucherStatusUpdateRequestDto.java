package com.epam.finaltask.dto.request;

import com.epam.finaltask.model.VoucherStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoucherStatusUpdateRequestDto {
    @NotNull(message = "Voucher status cannot be null")
    private VoucherStatus status;
}
