package com.simplifia.Symplifia.dto;

import com.simplifia.Symplifia.models.Invoice;
import com.simplifia.Symplifia.models.PaymentMethod;
import com.simplifia.Symplifia.models.PaymentStatue;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.Date;

@Data
@NoArgsConstructor
public class InvoiceDTO {
    private Integer idInvoice;
    private int invoiceMonth;
    private Year invoiceYear;
    private Date invoiceDate;
    private BigDecimal price;
    private PaymentStatue paymentStatue;
    private PaymentMethod paymentMethod;
    private Integer idSyndic;

    public InvoiceDTO(Invoice invoice){
        this.idInvoice = invoice.getIdInvoice();
        this.invoiceMonth = invoice.getInvoiceMonth().getValue(); // Convert Month to int
        this.invoiceYear = invoice.getInvoiceYear();
        this.invoiceDate = invoice.getInvoiceDate();
        this.price = invoice.getPrice();
        this.paymentStatue = invoice.getPaymentStatue();
        this.paymentMethod = invoice.getPaymentMethod();
        this.idSyndic = invoice.getSyndic().getIdSyndic();
    }
}


