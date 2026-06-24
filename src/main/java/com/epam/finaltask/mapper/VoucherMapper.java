package com.epam.finaltask.mapper;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDTO;
import com.epam.finaltask.model.Voucher;
import com.epam.finaltask.model.VoucherStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherMapper {
    Voucher toVoucher(VoucherDTO voucherDTO);

    @Mapping(target = "userId", source = "user.id")
    VoucherDTO toVoucherDTO(Voucher voucher);

    List<Voucher> toVoucherList(List<VoucherDTO> vouchersDto);

    List<VoucherDTO> toVoucherDTOList(List<Voucher> vouchers);

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

    default PagedModel<VoucherDTO> toVoucherDtoPage(Page<Voucher> voucherPage) {
        List<VoucherDTO> voucherDtoList = toVoucherDTOList(voucherPage.getContent());
        return new PagedModel<>(new PageImpl<>(voucherDtoList, voucherPage.getPageable(), voucherPage.getTotalElements()));
    }
}
