package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.repository.ExpenseRepository;
import com.simplifia.Symplifia.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final InvoiceRepository invoiceRepository;
    private final ExpenseRepository expenseRepository;

    public BigDecimal getTotalInvoicePriceBetweenDates(Date startDate, Date endDate, Integer syndicId) {
        return invoiceRepository.findTotalInvoicePriceBetweenDates(startDate, endDate, syndicId);
    }

    public BigDecimal getTotalExpenseCostBetweenDates(Date startDate, Date endDate, Integer syndicId) {
        return expenseRepository.findTotalExpenseCostBetweenDates(startDate, endDate, syndicId);
    }
}
