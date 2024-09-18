package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.InvoiceDTO;
import com.simplifia.Symplifia.dto.ResidentDTO;
import com.simplifia.Symplifia.services.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/residents")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ResidentController {

    private final ResidentService residentService;


    @GetMapping("/{idSyndic}")
    public ResponseEntity<List<ResidentDTO>> getResidentsWithInvoicesForYear(
            @PathVariable("idSyndic") Integer idSyndic,
            @RequestParam("year") Integer year) {
        List<ResidentDTO> residents = residentService.getResidentsWithInvoicesForYear(idSyndic, year);
        return ResponseEntity.ok(residents);
    }

    @GetMapping("/{idResident}/invoices")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesForResidentByYear(
            @PathVariable Integer idResident,
            @RequestParam Integer year) {
        List<InvoiceDTO> invoices = residentService.getInvoicesForResidentByYear(idResident, year);
        return ResponseEntity.ok(invoices);
    }

}
