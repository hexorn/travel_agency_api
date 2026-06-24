package com.epam.finaltask.dto.request;

import com.epam.finaltask.dto.response.VoucherDTO;
import com.epam.finaltask.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequestDto {
    @NotBlank
    @Size(min = 5, max = 255)
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;
}
