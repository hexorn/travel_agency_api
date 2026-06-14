package com.epam.finaltask.service;

import com.epam.finaltask.dto.VoucherDTO;
import com.epam.finaltask.mapper.VoucherMapper;
import com.epam.finaltask.model.*;
import com.epam.finaltask.repository.UserRepository;
import com.epam.finaltask.repository.VoucherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class VoucherServiceImpl implements VoucherService{
    private final VoucherRepository voucherRepository;
    private final UserRepository userRepository;
    private final VoucherMapper voucherMapper;

    @Override
    public VoucherDTO create(VoucherDTO voucherDTO) {
        Voucher voucher = voucherMapper.toVoucher(voucherDTO);

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucher));
    }

    @Override
    public VoucherDTO order(String id, String userId) {
        Optional<Voucher> optionalVoucher = voucherRepository.findById(UUID.fromString(id));
        if(optionalVoucher.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", id));
        }

        Optional<User> userOptional = userRepository.findById(UUID.fromString(userId));
        if(userOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("User with id: %s not found", userId));
        }

        Voucher voucher = optionalVoucher.get();
        User user = userOptional.get();
        voucher.setUser(user);

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucher));
    }

    @Override
    public VoucherDTO update(String id, VoucherDTO voucherDTO) {
        Optional<Voucher> voucherOptional = voucherRepository.findById(UUID.fromString(id));
        if(voucherOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Voucher with id: %s not found", id));
        }
        Voucher voucherPayload = voucherMapper.toVoucher(voucherDTO);
        if(!voucherOptional.get().getId().equals(voucherPayload.getId())) {
            throw new IllegalArgumentException("Vouchers id do not match");
        }
//        voucherPayload.setId(voucherOptional.get().getId());

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
        voucherOptional.get().setHot(voucher.isHot());

        return voucherMapper.toVoucherDTO(voucherRepository.save(voucherOptional.get()));
    }

    @Override
    public List<VoucherDTO> findAllByUserId(String userId) {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAllByUserId(UUID.fromString(userId)));
    }

    @Override
    public List<VoucherDTO> findAllByTourType(TourType tourType) {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAllByTourType(tourType));
    }

    @Override
    public List<VoucherDTO> findAllByTransferType(String transferType) {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAllByTransferType(TransferType.valueOf(transferType)));
    }

    @Override
    public List<VoucherDTO> findAllByPrice(Double price) {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAllByPrice(price));
    }

    @Override
    public List<VoucherDTO> findAllByHotelType(HotelType hotelType) {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAllByHotelType(hotelType));
    }

    @Override
    public List<VoucherDTO> findAll() {
        return voucherMapper.toVoucherDTOList(voucherRepository.findAll());
    }
}
