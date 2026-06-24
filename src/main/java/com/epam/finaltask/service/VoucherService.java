package com.epam.finaltask.service;

import java.util.List;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherHotStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDTO;
import com.epam.finaltask.dto.request.VoucherSearchQueryParamsRequestDto;
import com.epam.finaltask.model.HotelType;
import com.epam.finaltask.model.TourType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface VoucherService {
    VoucherDTO create(VoucherCreateRequestDto voucherDTO);
    VoucherDTO orderVoucher(String id, String userId);
    VoucherDTO update(String id, VoucherUpdateRequestDto voucherDTO);
    void delete(String voucherId);
    VoucherDTO changeHotStatus(String id, VoucherDTO voucherDTO);
    PagedModel<VoucherDTO> findAllByUserId(String userId,VoucherSearchQueryParamsRequestDto queryParams, Pageable pageable);
    List<VoucherDTO> findAll();
    PagedModel<VoucherDTO> findAllBySpecification(VoucherSearchQueryParamsRequestDto queryParams, Pageable pageable);
    VoucherDTO updateVoucherStatus(String id, VoucherStatusUpdateRequestDto dto);
    VoucherDTO updateVoucherHotStatus(String id, VoucherHotStatusUpdateRequestDto dto);
    VoucherDTO getVoucherById(String voucherId);
}
