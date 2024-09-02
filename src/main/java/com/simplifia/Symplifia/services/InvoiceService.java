package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.models.Invoice;
import com.simplifia.Symplifia.models.PaymentStatue;
import com.simplifia.Symplifia.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Transactional
    public Invoice confirmPayment(Integer residentId, Month invoiceMonth, Year invoiceYear) {
        Invoice invoice = invoiceRepository.findByResident_idResidentAndInvoiceMonthAndInvoiceYear(residentId, invoiceMonth, invoiceYear);
        invoice.setPaymentStatue(PaymentStatue.Payed);
        return invoiceRepository.save(invoice);
    }
}