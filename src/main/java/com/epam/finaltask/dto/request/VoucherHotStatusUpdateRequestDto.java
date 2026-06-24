package com.epam.finaltask.dto.request;

import com.epam.finaltask.model.VoucherStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoucherHotStatusUpdateRequestDto {
    @NotNull(message = "Voucher status cannot be null")
    @JsonProperty("isHot")
    private boolean isHot;
}
