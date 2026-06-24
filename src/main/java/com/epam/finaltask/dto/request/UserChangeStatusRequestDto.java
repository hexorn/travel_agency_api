package com.epam.finaltask.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangeStatusRequestDto {
    @NotNull(message = "Status cannot be null")
    private Boolean active;
}
