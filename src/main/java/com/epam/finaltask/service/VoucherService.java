package com.epam.finaltask.service;

import java.util.List;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherHotStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDto;
import com.epam.finaltask.dto.request.VoucherSearchQueryParamsRequestDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface VoucherService {
    VoucherDto create(VoucherCreateRequestDto voucherDTO);
    VoucherDto orderVoucher(String id, String userId);
    VoucherDto update(String id, VoucherUpdateRequestDto voucherDTO);
    void delete(String voucherId);
    VoucherDto changeHotStatus(String id, VoucherDto voucherDTO);
    PagedModel<VoucherDto> findAllByUserId(String userId, VoucherSearchQueryParamsRequestDto queryParams, Pageable pageable);
    List<VoucherDto> findAll();
    PagedModel<VoucherDto> findAllBySpecification(VoucherSearchQueryParamsRequestDto queryParams, Pageable pageable);
    VoucherDto updateVoucherStatus(String id, VoucherStatusUpdateRequestDto dto);
    VoucherDto updateVoucherHotStatus(String id, VoucherHotStatusUpdateRequestDto dto);
    VoucherDto getVoucherById(String voucherId);
}
