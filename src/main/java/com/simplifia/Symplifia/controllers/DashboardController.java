package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/totals")
    public Map<String, BigDecimal> getTotalsBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @RequestParam("syndicId") Integer syndicId) {

        BigDecimal totalInvoicePrice = dashboardService.getTotalInvoicePriceBetweenDates(startDate, endDate, syndicId);
        BigDecimal totalExpenseCost = dashboardService.getTotalExpenseCostBetweenDates(startDate, endDate, syndicId);

        Map<String, BigDecimal> totals = new HashMap<>();
        totals.put("totalInvoicePrice", totalInvoicePrice != null ? totalInvoicePrice : BigDecimal.ZERO);
        totals.put("totalExpenseCost", totalExpenseCost != null ? totalExpenseCost : BigDecimal.ZERO);
        totals.put("remaining", (totalInvoicePrice != null ? totalInvoicePrice : BigDecimal.ZERO)
                .subtract(totalExpenseCost != null ? totalExpenseCost : BigDecimal.ZERO));

        return totals;
    }
}
