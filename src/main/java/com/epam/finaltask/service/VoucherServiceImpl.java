package com.epam.finaltask.service;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherHotStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDTO;
import com.epam.finaltask.dto.request.VoucherSearchQueryParamsRequestDto;
import com.epam.finaltask.mapper.VoucherMapper;
import com.epam.finaltask.model.*;
import com.epam.finaltask.repository.UserRepository;
import com.epam.finaltask.repository.VoucherRepository;
import com.epam.finaltask.specification.VoucherSearchSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class VoucherServiceImpl implements VoucherService{
    private final VoucherRepository voucherRepository;
    private final UserRepository userRepository;
    private final VoucherMapper voucherMapper;

    @Override
    public VoucherDTO create(VoucherCreateRequestDto voucherDTO) {
        Voucher voucher = voucherMapper.toVoucherCreate(voucherDTO);
        voucher.setStatus(VoucherStatus.AVAILABLE);

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucher));
    }

    @Override
    public VoucherDTO orderVoucher(String voucherId, String userId) {
        Optional<Voucher> optionalVoucher = voucherRepository.findById(UUID.fromString(voucherId));
        if(optionalVoucher.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", voucherId));
        }

        Voucher voucher = optionalVoucher.get();
        if(Objects.nonNull(voucher.getUser()) || !voucher.getStatus().equals(VoucherStatus.AVAILABLE)) {
            throw new IllegalArgumentException("Voucher already ordered");
        }

        Optional<User> userOptional = userRepository.findById(UUID.fromString(userId));
        if(userOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("User with id: %s not found", userId));
        }

        User user = userOptional.get();
        voucher.setUser(user);
        voucher.setStatus(VoucherStatus.REGISTERED);

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucher));
    }

    @Override
    public VoucherDTO update(String id, VoucherUpdateRequestDto voucherDTO) {
        Optional<Voucher> voucherOptional = voucherRepository.findById(UUID.fromString(id));
        if(voucherOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", id));
        }
        Voucher existingVoucher = voucherOptional.get();
        Voucher voucherPayload = voucherMapper.toVoucherUpdate(voucherDTO);
//        if(!voucherOptional.get().getId().equals(voucherPayload.getId())) {
//            throw new IllegalArgumentException("Vouchers id do not match");
//        }

        voucherPayload.setId(existingVoucher.getId());
        voucherPayload.setStatus(existingVoucher.getStatus());
        voucherPayload.setUser(existingVoucher.getUser());
        return voucherMapper.toVoucherDTO(voucherRepository.save(voucherPayload));
    }

    @Override
    public void delete(String voucherId) {
        voucherRepository.deleteById(UUID.fromString(voucherId));
    }

    @Override
    public VoucherDTO changeHotStatus(String id, VoucherDTO voucherDTO) {
        Voucher voucher = voucherMapper.toVoucher(voucherDTO);
        Optional<Voucher> voucherOptional = voucherRepository.findById(UUID.fromString(id));
        if(voucherOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", id));
        }
        voucherOptional.get().setIsHot(voucher.getIsHot());

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucherOptional.get()));
    }

    @Override
    public PagedModel<VoucherDTO> findAllByUserId(String userId, VoucherSearchQueryParamsRequestDto queryParams, Pageable pageable) {
        Specification<Voucher> specification = Specification.where(VoucherSearchSpecifications.hasTourType(queryParams.getTourType()))
                .and(VoucherSearchSpecifications.hasHotelType(queryParams.getHotelType()))
                .and(VoucherSearchSpecifications.hasTransferType(queryParams.getTransferType()))
                .and(VoucherSearchSpecifications.hasMinPrice(queryParams.getMinPrice()))
                .and(VoucherSearchSpecifications.hasMaxPrice(queryParams.getMaxPrice()));
    /// TODO add specification usage
        Page<Voucher> vouchers = voucherRepository.findAllByUserId(UUID.fromString(userId), pageable);
        return voucherMapper.toVoucherDtoPage(vouchers);
    }

    @Override
    public List<VoucherDTO> findAll() {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAll());
    }

    @Override
    public PagedModel<VoucherDTO> findAllBySpecification(VoucherSearchQueryParamsRequestDto queryParams, Pageable pageable) {

        Specification<Voucher> specification = Specification.where(VoucherSearchSpecifications.hasTourType(queryParams.getTourType()))
                .and(VoucherSearchSpecifications.hasHotelType(queryParams.getHotelType()))
                .and(VoucherSearchSpecifications.hasTransferType(queryParams.getTransferType()))
//                .and(VoucherSpecifications.hasPrice(queryParams.getPrice()));
                .and(VoucherSearchSpecifications.hasMinPrice(queryParams.getMinPrice()))
                .and(VoucherSearchSpecifications.hasMaxPrice(queryParams.getMaxPrice()));

        return voucherMapper.toVoucherDtoPage(voucherRepository.findAll(specification, pageable));
    }

    @Override
    public VoucherDTO updateVoucherStatus(String id, VoucherStatusUpdateRequestDto dto) {
        var voucher = voucherRepository.findById(UUID.fromString(id));
        if(voucher.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", id));
        }
        voucher.get().setStatus(dto.getStatus());

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucher.get()));
    }

    @Override
    public VoucherDTO updateVoucherHotStatus(String id, VoucherHotStatusUpdateRequestDto dto) {
        Optional<Voucher> voucher = voucherRepository.findById(UUID.fromString(id));
        if(voucher.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", id));
        }

        voucher.get().setIsHot(dto.isHot());

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucher.get()));
    }

    @Override
    public VoucherDTO getVoucherById(String voucherId) {
        Optional<Voucher> voucherOptional = voucherRepository.findById(UUID.fromString(voucherId));
        if(voucherOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", voucherId));
        }

        return voucherMapper.toVoucherDTO(voucherOptional.get());
    }
}



