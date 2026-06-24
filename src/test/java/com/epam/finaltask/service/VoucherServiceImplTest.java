package com.epam.finaltask.service;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherHotStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDTO;
import com.epam.finaltask.mapper.VoucherMapper;
import com.epam.finaltask.model.User;
import com.epam.finaltask.model.Voucher;
import com.epam.finaltask.model.VoucherStatus;
import com.epam.finaltask.repository.UserRepository;
import com.epam.finaltask.repository.VoucherRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VoucherServiceImplTest {
    @Mock
    private VoucherRepository voucherRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private VoucherMapper voucherMapper;

    @InjectMocks
    private VoucherServiceImpl voucherService;

    @Test
    @DisplayName("create: Should create voucher successfully")
    void createVoucher_Success() {
        // Given
        VoucherCreateRequestDto dto = new VoucherCreateRequestDto();

        Voucher voucher = new Voucher();

        Voucher savedVoucher = new Voucher();
        savedVoucher.setStatus(VoucherStatus.AVAILABLE);

        VoucherDTO expected = new VoucherDTO();

        when(voucherMapper.toVoucherCreate(dto)).thenReturn(voucher);
        when(voucherRepository.save(voucher)).thenReturn(savedVoucher);
        when(voucherMapper.toVoucherDTO(savedVoucher)).thenReturn(expected);

        // When
        VoucherDTO result = voucherService.create(dto);

        // Then
        assertNotNull(result);

        assertEquals(VoucherStatus.AVAILABLE, voucher.getStatus());

        verify(voucherRepository).save(voucher);
    }

    @Test
    @DisplayName("orderVoucher: Should order voucher When voucher and user exist")
    void orderVoucher_Success() {
        // Given
        UUID voucherId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        User user = new User();
        user.setId(userId);

        Voucher voucher = new Voucher();
        voucher.setId(voucherId);
        voucher.setStatus(VoucherStatus.AVAILABLE);

        VoucherDTO expected = new VoucherDTO();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(voucher));

        when(userRepository.findById(userId))
                .thenReturn(Optional.of(user));

        when(voucherRepository.save(voucher))
                .thenReturn(voucher);

        when(voucherMapper.toVoucherDTO(voucher))
                .thenReturn(expected);

        // When
        VoucherDTO result =
                voucherService.orderVoucher(voucherId.toString(), userId.toString());

        // Then
        assertNotNull(result);

        assertEquals(VoucherStatus.REGISTERED, voucher.getStatus());
        assertEquals(user, voucher.getUser());

        verify(voucherRepository).save(voucher);
    }

    @Test
    @DisplayName("orderVoucher: Should throw exception When voucher not found")
    void orderVoucher_VoucherNotFound() {
        UUID voucherId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> voucherService.orderVoucher(
                        voucherId.toString(),
                        userId.toString()
                )
        );
    }

    @Test
    @DisplayName("orderVoucher: Should throw exception when voucher already ordered")
    void orderVoucher_AlreadyOrdered() {
        UUID voucherId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        Voucher voucher = new Voucher();
        voucher.setId(voucherId);
        voucher.setStatus(VoucherStatus.REGISTERED);
        voucher.setUser(new User());

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(voucher));

        assertThrows(
                IllegalArgumentException.class,
                () -> voucherService.orderVoucher(
                        voucherId.toString(),
                        userId.toString()
                )
        );
    }

    @Test
    @DisplayName("orderVoucher: Should throw exception when user not found")
    void orderVoucher_UserNotFound() {
        UUID voucherId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        Voucher voucher = new Voucher();
        voucher.setId(voucherId);
        voucher.setStatus(VoucherStatus.AVAILABLE);

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(voucher));

        when(userRepository.findById(userId))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> voucherService.orderVoucher(
                        voucherId.toString(),
                        userId.toString()
                )
        );
    }

    @Test
    @DisplayName("update: Should update voucher successfully")
    void updateVoucher_Success() {
        UUID voucherId = UUID.randomUUID();

        Voucher existingVoucher = new Voucher();
        existingVoucher.setId(voucherId);
        existingVoucher.setStatus(VoucherStatus.AVAILABLE);

        VoucherUpdateRequestDto dto = new VoucherUpdateRequestDto();

        Voucher payload = new Voucher();

        VoucherDTO expected = new VoucherDTO();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(existingVoucher));

        when(voucherMapper.toVoucherUpdate(dto))
                .thenReturn(payload);

        when(voucherRepository.save(any(Voucher.class)))
                .thenReturn(payload);

        when(voucherMapper.toVoucherDTO(payload))
                .thenReturn(expected);

        VoucherDTO result =
                voucherService.update(voucherId.toString(), dto);

        assertNotNull(result);

        verify(voucherRepository).save(any(Voucher.class));
    }

    @Test
    @DisplayName("update: Should throw exception when voucher not found")
    void updateVoucher_NotFound() {
        UUID voucherId = UUID.randomUUID();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> voucherService.update(
                        voucherId.toString(),
                        new VoucherUpdateRequestDto()
                )
        );
    }

    @Test
    @DisplayName("delete: Should delete voucher by id")
    void deleteVoucher_Success() {
        UUID voucherId = UUID.randomUUID();

        voucherService.delete(voucherId.toString());

        verify(voucherRepository)
                .deleteById(voucherId);
    }

    @Test
    @DisplayName("updateVoucherStatus: Should update voucher status")
    void updateVoucherStatus_Success() {
        UUID voucherId = UUID.randomUUID();

        Voucher voucher = new Voucher();
        voucher.setId(voucherId);

        VoucherStatusUpdateRequestDto dto =
                new VoucherStatusUpdateRequestDto();

        dto.setStatus(VoucherStatus.PAID);

        VoucherDTO expected = new VoucherDTO();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(voucher));

        when(voucherRepository.save(voucher))
                .thenReturn(voucher);

        when(voucherMapper.toVoucherDTO(voucher))
                .thenReturn(expected);

        VoucherDTO result =
                voucherService.updateVoucherStatus(
                        voucherId.toString(),
                        dto
                );

        assertNotNull(result);

        assertEquals(VoucherStatus.PAID, voucher.getStatus());
    }

    @Test
    @DisplayName("updateVoucherHotStatus: Should update hot status")
    void updateVoucherHotStatus_Success() {
        UUID voucherId = UUID.randomUUID();

        Voucher voucher = new Voucher();

        VoucherHotStatusUpdateRequestDto dto =
                new VoucherHotStatusUpdateRequestDto();

        dto.setHot(true);

        VoucherDTO expected = new VoucherDTO();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(voucher));

        when(voucherRepository.save(voucher))
                .thenReturn(voucher);

        when(voucherMapper.toVoucherDTO(voucher))
                .thenReturn(expected);

        VoucherDTO result =
                voucherService.updateVoucherHotStatus(
                        voucherId.toString(),
                        dto
                );

        assertNotNull(result);

        assertTrue(voucher.getIsHot());
    }

    @Test
    @DisplayName("getVoucherById: Should return voucher when voucher exists")
    void getVoucherById_Success() {
        UUID voucherId = UUID.randomUUID();

        Voucher voucher = new Voucher();

        VoucherDTO expected = new VoucherDTO();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.of(voucher));

        when(voucherMapper.toVoucherDTO(voucher))
                .thenReturn(expected);

        VoucherDTO result =
                voucherService.getVoucherById(voucherId.toString());

        assertNotNull(result);

        verify(voucherMapper)
                .toVoucherDTO(voucher);
    }

    @Test
    @DisplayName("getVoucherById: Should throw exception when voucher not found")
    void getVoucherById_NotFound() {
        UUID voucherId = UUID.randomUUID();

        when(voucherRepository.findById(voucherId))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> voucherService.getVoucherById(
                        voucherId.toString()
                )
        );
    }
}
