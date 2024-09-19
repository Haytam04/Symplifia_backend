package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.repository.ExpenseRepository;
import com.simplifia.Symplifia.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String, BigDecimal> getTotalsMap(Date startDate,Date endDate,Integer syndicId){
        BigDecimal totalInvoicePrice = getTotalInvoicePriceBetweenDates(startDate, endDate, syndicId);
        BigDecimal totalExpenseCost =  getTotalExpenseCostBetweenDates(startDate, endDate, syndicId);

        Map<String, BigDecimal> totals = new HashMap<>();
        totals.put("totalInvoicePrice", totalInvoicePrice != null ? totalInvoicePrice : BigDecimal.ZERO);
        totals.put("totalExpenseCost", totalExpenseCost != null ? totalExpenseCost : BigDecimal.ZERO);
        totals.put("remaining", (totalInvoicePrice != null ? totalInvoicePrice : BigDecimal.ZERO)
                .subtract(totalExpenseCost != null ? totalExpenseCost : BigDecimal.ZERO));

        return totals;
    }
}
