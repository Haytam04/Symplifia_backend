package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.dto.PaymentDetailsDTO;
import com.simplifia.Symplifia.models.Building;
import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final ResidentRepository residentRepository;

    public PaymentDetailsDTO getPaymentDetails(Integer residentId, String month, int year) {
        Resident resident = residentRepository.findById(residentId)
                .orElseThrow(() -> new RuntimeException("Resident not found"));

        Building building = resident.getBuilding();
        Syndic syndic = building.getSyndic();

        PaymentDetailsDTO paymentDetails = new PaymentDetailsDTO();
        paymentDetails.setSyndicId(syndic.getIdSyndic());
        paymentDetails.setMonth(month);
        paymentDetails.setYear(year);
        paymentDetails.setSyndicFullName(syndic.getFullName());
        paymentDetails.setSyndicBankName(syndic.getBankName());
        paymentDetails.setSyndicBankAccount(syndic.getBankAccount());
        paymentDetails.setBuildingPrice(building.getSyndicPrice());

        return paymentDetails;
    }
}
