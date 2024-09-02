package com.simplifia.Symplifia.dto;

import com.simplifia.Symplifia.models.Building;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PaymentDetailsDTO {
        private Integer syndicId;
        private String month;
        private int year;
        private String syndicFullName;
        private String syndicBankName;
        private String syndicBankAccount;
        private BigDecimal buildingPrice;

}
