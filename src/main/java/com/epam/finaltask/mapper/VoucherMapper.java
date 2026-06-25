package com.epam.finaltask.mapper;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDto;
import com.epam.finaltask.model.Voucher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherMapper {
    Voucher toVoucher(VoucherDto voucherDTO);

    @Mapping(target = "userId", source = "user.id")
    VoucherDto toVoucherDTO(Voucher voucher);

    List<Voucher> toVoucherList(List<VoucherDto> vouchersDto);

    List<VoucherDto> toVoucherDTOList(List<Voucher> vouchers);

    @Mapping(target = "isHot", source = "isHot")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "status", ignore = true)
    Voucher toVoucherUpdate(VoucherUpdateRequestDto voucherDTO);

    @Mapping(target = "isHot", source = "isHot")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "status", ignore = true)
    Voucher toVoucherCreate(VoucherCreateRequestDto voucherDTO);

    default PagedModel<VoucherDto> toVoucherDtoPage(Page<Voucher> voucherPage) {
        List<VoucherDto> voucherDtoList = toVoucherDTOList(voucherPage.getContent());
        return new PagedModel<>(new PageImpl<>(voucherDtoList, voucherPage.getPageable(), voucherPage.getTotalElements()));
    }
}
