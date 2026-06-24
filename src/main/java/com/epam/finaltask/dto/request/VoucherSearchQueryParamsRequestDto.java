package com.epam.finaltask.dto.request;

import com.epam.finaltask.model.HotelType;
import com.epam.finaltask.model.TourType;
import com.epam.finaltask.model.TransferType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoucherSearchQueryParamsRequestDto {
    TourType tourType;
    Double minPrice;
    Double maxPrice;
    TransferType transferType;
    HotelType hotelType;

}