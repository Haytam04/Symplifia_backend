package com.simplifia.Symplifia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ResidentDTO {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String buildingName;
    private List<InvoiceDTO> invoices;



   public ResidentDTO(Integer id, String fullName, String phoneNumber, String buildingName, List<InvoiceDTO> invoices) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.buildingName = buildingName;
        this.invoices = invoices;
    }
}


