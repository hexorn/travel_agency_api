package com.epam.finaltask.specification;

import com.epam.finaltask.model.HotelType;
import com.epam.finaltask.model.TourType;
import com.epam.finaltask.model.TransferType;
import com.epam.finaltask.model.Voucher;
import org.springframework.data.jpa.domain.Specification;

public final class VoucherSearchSpecifications {
    public static Specification<Voucher> hasTourType(TourType type) {
        return (root, query, criteriaBuilder) ->
                type == null ? null : criteriaBuilder.equal(root.get("tourType"), type.toString());
    }

    public static Specification<Voucher> hasTransferType(TransferType type) {
        return (root, query, criteriaBuilder) ->
                type == null ? null : criteriaBuilder.equal(root.get("transferType"), type.toString());
    }

    public static Specification<Voucher> hasHotelType(HotelType type) {
        return (root, query, criteriaBuilder) ->
                type == null ? null : criteriaBuilder.equal(root.get("hotelType"), type.toString());
    }

    public static Specification<Voucher> hasMinPrice(Double price) {
        return (root, query, criteriaBuilder) ->
                price == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }
    public static Specification<Voucher> hasMaxPrice(Double price) {
        return (root, query, criteriaBuilder) ->
                price == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

}
