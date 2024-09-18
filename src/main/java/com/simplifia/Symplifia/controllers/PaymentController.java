package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.PaymentDetailsDTO;
import com.simplifia.Symplifia.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/details")
    public ResponseEntity<PaymentDetailsDTO> getPaymentDetails(
            @RequestParam Integer residentId,
            @RequestParam String month,
            @RequestParam int year) {
        PaymentDetailsDTO paymentDetails = paymentService.getPaymentDetails(residentId, month, year);
        return ResponseEntity.ok(paymentDetails);
    }
}
