package com.epam.finaltask.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSearchQueryParamsRequestDto {
    private String email;
    private Boolean active;
}
