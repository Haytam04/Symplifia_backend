package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.InvoiceDTO;
import com.simplifia.Symplifia.models.Invoice;
import com.simplifia.Symplifia.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.Year;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
@CrossOrigin("*")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PutMapping("/confirm-payment")
    public ResponseEntity<InvoiceDTO> confirmPayment(
            @RequestParam Integer residentId,
            @RequestParam int invoiceMonth,
            @RequestParam int invoiceYear) {

        Month month = Month.of(invoiceMonth+1);
        Year year = Year.of(invoiceYear);

        Invoice confirmedInvoice = invoiceService.confirmPayment(residentId, month, year);
        return ResponseEntity.ok(new InvoiceDTO(confirmedInvoice));
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoiceDetails) {
        Invoice savedInvoice = invoiceService.createInvoice(invoiceDetails);
        return ResponseEntity.ok(savedInvoice);
    }
}
