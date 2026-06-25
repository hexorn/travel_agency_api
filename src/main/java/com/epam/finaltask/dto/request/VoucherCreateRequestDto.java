package com.epam.finaltask.dto.request;

import com.epam.finaltask.model.HotelType;
import com.epam.finaltask.model.TourType;
import com.epam.finaltask.model.TransferType;
import com.epam.finaltask.validators.ValidDateRange;
import com.epam.finaltask.validators.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@ValidDateRange
public class VoucherCreateRequestDto {
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Tour type cannot be null")
    private TourType tourType;

    @NotNull(message = "Transfer type cannot be null")
    private TransferType transferType;

    @NotNull(message = "Hotel type cannot be null")
    private HotelType hotelType;

    @NotNull(message = "Arrival date cannot be null")
    private LocalDate arrivalDate;

    @NotNull(message = "Eviction date cannot be null")
    private LocalDate evictionDate;

    @NotNull(message = "Hot status cannot be null")
    private Boolean isHot;
}
