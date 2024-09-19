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
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/totals")
    public Map<String, BigDecimal> getTotalsBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @RequestParam("syndicId") Integer syndicId) {

      return  dashboardService.getTotalsMap(startDate,endDate,syndicId);
    }
}
