package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.models.Invoice;
import com.simplifia.Symplifia.models.PaymentStatue;
import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.InvoiceRepository;
import com.simplifia.Symplifia.repository.ResidentRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final SyndicRepository syndicRepository;
    private final ResidentRepository residentRepository;

    @Transactional
    public Invoice confirmPayment(Integer residentId, Month invoiceMonth, Year invoiceYear) {
        Invoice invoice = invoiceRepository.findByResident_idResidentAndInvoiceMonthAndInvoiceYear(residentId, invoiceMonth, invoiceYear);
        invoice.setPaymentStatue(PaymentStatue.Payed);
        return invoiceRepository.save(invoice);
    }

    public Invoice createInvoice(Invoice invoiceDetails) {
        Resident resident = residentRepository.findById(invoiceDetails.getResident().getIdResident())
                .orElse(null);
        Syndic syndic = syndicRepository.findById(invoiceDetails.getSyndic().getIdSyndic())
                .orElse(null);

        Invoice invoice = new Invoice();
        invoice.setInvoiceMonth(invoiceDetails.getInvoiceMonth());
        invoice.setInvoiceYear(invoiceDetails.getInvoiceYear());
        invoice.setInvoiceDate(invoiceDetails.getInvoiceDate());
        invoice.setPrice(invoiceDetails.getPrice());
        invoice.setPaymentStatue(invoiceDetails.getPaymentStatue());
        invoice.setPaymentMethod(invoiceDetails.getPaymentMethod());
        invoice.setResident(resident);
        invoice.setSyndic(syndic);

        return invoiceRepository.save(invoice);
    }
}