package com.epam.finaltask.restcontroller;

import com.epam.finaltask.dto.request.VoucherCreateRequestDto;
import com.epam.finaltask.dto.request.VoucherHotStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherStatusUpdateRequestDto;
import com.epam.finaltask.dto.request.VoucherUpdateRequestDto;
import com.epam.finaltask.dto.response.VoucherDTO;
import com.epam.finaltask.dto.request.VoucherSearchQueryParamsRequestDto;
import com.epam.finaltask.service.VoucherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vouchers")
public class VoucherRestController  {
    private final VoucherService voucherService;

    @GetMapping("/user/{userId}")
    public PagedModel<VoucherDTO> getVouchersByUserId(@PathVariable(name = "userId") String userId,
                                                      @ModelAttribute VoucherSearchQueryParamsRequestDto queryParams,
                                                      @PageableDefault Pageable pageable) {
        return voucherService.findAllByUserId(userId, queryParams, pageable);
    }

    @PatchMapping("/{voucherId}/status")
    public VoucherDTO updateVoucherStatus(@PathVariable(name = "voucherId") String id, @Valid @RequestBody VoucherStatusUpdateRequestDto voucherDTO ) {
        return voucherService.updateVoucherStatus(id, voucherDTO);
    }

    @PatchMapping("/{voucherId}/hot-status")
    public VoucherDTO updateVoucherHotStatus(@PathVariable(name = "voucherId") String id, @RequestBody VoucherHotStatusUpdateRequestDto statusUpdateDto) {
        return voucherService.updateVoucherHotStatus(id, statusUpdateDto);
    }

    @PostMapping
    public ResponseEntity<VoucherDTO> createVoucher(@RequestBody @Valid VoucherCreateRequestDto voucherDTO) {
        return ResponseEntity.status(201).body(voucherService.create(voucherDTO));
    }

    @DeleteMapping("/{voucherId}")
    public ResponseEntity<?> deleteVoucher(@PathVariable(name = "voucherId") String voucherId) {
        voucherService.delete(voucherId);

        return ResponseEntity.noContent().build();
    }

//    @PatchMapping("/{voucherId}")
//    public ResponseEntity<VoucherDTO> updateVoucher(@PathVariable(name = "voucherId") String voucherId, VoucherDTO voucherDTO) {
//        return ResponseEntity.ok().body(voucherService.update(voucherId, voucherDTO));
//    }

    @GetMapping("/{voucherId}")
    public VoucherDTO getVoucher(@PathVariable(name = "voucherId") String voucherId) {
        return voucherService.getVoucherById(voucherId);
    }

    @GetMapping
    public PagedModel<VoucherDTO> getVouchers(@ModelAttribute VoucherSearchQueryParamsRequestDto queryParams, @PageableDefault Pageable pageable) {
        return voucherService.findAllBySpecification(queryParams, pageable);
    }

    @PatchMapping("/{voucherId}/users/{userId}")
    public VoucherDTO orderVoucher(@PathVariable(name = "voucherId") String voucherId, @PathVariable(name = "userId") String userId) {
        return voucherService.orderVoucher(voucherId, userId);
    }

    @PutMapping("/{voucherId}")
    public VoucherDTO updateVoucher(@PathVariable(name = "voucherId") String voucherId, @RequestBody @Valid VoucherUpdateRequestDto dto) {
        return voucherService.update(voucherId, dto);
    }
}
