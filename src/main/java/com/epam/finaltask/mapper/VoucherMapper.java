package com.epam.finaltask.mapper;

import com.epam.finaltask.dto.VoucherDTO;
import com.epam.finaltask.model.Voucher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherMapper {
    Voucher toVoucher(VoucherDTO voucherDTO);
    VoucherDTO toVoucherDTO(Voucher voucher);
    List<Voucher> toVoucherList(List<VoucherDTO> userDTO);
    List<VoucherDTO> toVoucherDTOList(List<Voucher> user);
}
