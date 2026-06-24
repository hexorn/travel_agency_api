package com.epam.finaltask.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.validation.constraints.*;
@Setter
@Getter
public class VoucherDTO {

    private String id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Tour type is required")
    private String tourType;

    @NotBlank(message = "Transfer type is required")
    private String transferType;

    @NotBlank(message = "Hotel type is required")
    private String hotelType;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Arrival date cannot be null")
    private LocalDate arrivalDate;

    @NotNull(message = "Eviction date cannot be null")
    private LocalDate evictionDate;

    private UUID userId;

//    @NotNull(message = "Arrival date cannot be null")
    private Boolean isHot;

}
