package com.epam.finaltask.restcontroller;

import com.epam.finaltask.dto.VoucherDTO;
import com.epam.finaltask.service.VoucherService;
import com.epam.finaltask.utils.ApiResponseCollectionWrapper;
import com.epam.finaltask.utils.ApiResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vouchers")
public class VoucherRestController  {
    private final VoucherService voucherService;

    @GetMapping
    public ApiResponseCollectionWrapper<List<VoucherDTO>> getVouchers() {
        return new ApiResponseCollectionWrapper<>(voucherService.findAll());
    }

    @GetMapping("/user/{userId}")
    public ApiResponseCollectionWrapper<List<VoucherDTO>> getVouchersByUserId(@PathVariable(name = "userId") String userId) {

        return new ApiResponseCollectionWrapper<>(voucherService.findAllByUserId(userId));
    }

    @PatchMapping("/{voucherId}/status")
    public ApiResponseWrapper<VoucherDTO> updateVoucherStatus(@PathVariable(name = "voucherId") String id, VoucherDTO voucherDTO ) {
//        return ResponseEntity.ok().body(voucherService.changeHotStatus(id, voucherDTO));
        return new ApiResponseWrapper<>(voucherService.changeHotStatus(id, voucherDTO), "OK", "Voucher status is successfully changed");
    }

    @PostMapping
    public ResponseEntity<ApiResponseWrapper<VoucherDTO>> createVoucher(VoucherDTO voucherDTO) {
        return ResponseEntity.status(201).body(new ApiResponseWrapper<>( voucherService.create(voucherDTO), "OK","Voucher is successfully created"));
    }

    @DeleteMapping("/{voucherId}")
    public ResponseEntity<ApiResponseWrapper<?>> deleteVoucher(@PathVariable(name = "voucherId") String voucherId) {
        voucherService.delete(voucherId);
        return ResponseEntity.ok().body(new ApiResponseWrapper<>(null,"OK",  String.format("Voucher with Id %s has been deleted", voucherId)));
    }

    @PatchMapping("/{voucherId}")
    public ResponseEntity<ApiResponseWrapper<VoucherDTO>> updateVoucher(@PathVariable(name = "voucherId") String voucherId, VoucherDTO voucherDTO) {
        return ResponseEntity.ok().body(new ApiResponseWrapper<>(voucherService.update(voucherId, voucherDTO),"OK",  "Voucher is successfully updated"));
    }
}
