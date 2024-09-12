package com.simplifia.Symplifia.services;

import com.simplifia.Symplifia.dto.InvoiceDTO;
import com.simplifia.Symplifia.dto.ResidentDTO;
import com.simplifia.Symplifia.models.PaymentMethod;
import com.simplifia.Symplifia.models.PaymentStatue;
import com.simplifia.Symplifia.models.Resident;
import com.simplifia.Symplifia.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ResidentService {

    private final ResidentRepository residentRepository;

    public List<ResidentDTO> getResidentsWithInvoicesForYear(Integer idSyndic, Integer year) {
        List<Object[]> residents = residentRepository.findResidentsBySyndic(idSyndic);

        List<ResidentDTO> residentDTOs = new ArrayList<>();

        for (Object[] resident : residents) {
            Integer idResident = (Integer) resident[0];
            String fullName = (String) resident[1];
            String phoneNumber = (String) resident[2];
            String buildingName = (String) resident[3];

            List<Object[]> invoices = residentRepository.findInvoicesForResidentByYear(idResident, year);
            List<InvoiceDTO> invoiceDTOs = new ArrayList<>();

            for (Object[] invoice : invoices) {
                InvoiceDTO invoiceDTO = new InvoiceDTO();
                invoiceDTO.setIdInvoice((Integer) invoice[0]);

                invoiceDTO.setInvoiceMonth((Byte) invoice[1]);

                // Convert the year (likely an Integer)
                Integer invoiceYearInt = (Integer) invoice[2];
                Year invoiceYear = Year.of(invoiceYearInt);
                invoiceDTO.setInvoiceYear(invoiceYear);

                invoiceDTO.setInvoiceDate((Date) invoice[3]);
                invoiceDTO.setPrice((BigDecimal) invoice[4]);
                invoiceDTO.setPaymentStatue(PaymentStatue.valueOf((String) invoice[5]));
                invoiceDTO.setPaymentMethod(PaymentMethod.valueOf((String) invoice[6]));
                invoiceDTO.setIdSyndic((Integer) invoice[7]);
                invoiceDTOs.add(invoiceDTO);
            }

            ResidentDTO residentDTO = new ResidentDTO();
            residentDTO.setId(idResident);
            residentDTO.setFullName(fullName);
            residentDTO.setPhoneNumber(phoneNumber);
            residentDTO.setBuildingName(buildingName);
            residentDTO.setInvoices(invoiceDTOs);

            residentDTOs.add(residentDTO);
        }
        return residentDTOs;
    }
    public List<InvoiceDTO> getInvoicesForResidentByYear(Integer idResident, Integer year) {
        List<Object[]> invoices = residentRepository.findInvoicesForResidentByYear(idResident, year);
        return invoices.stream().map(invoice -> {
            InvoiceDTO invoiceDTO = new InvoiceDTO();
            invoiceDTO.setIdInvoice((Integer) invoice[0]);
            invoiceDTO.setInvoiceMonth((Byte) invoice[1]);
            invoiceDTO.setInvoiceYear(Year.of((Integer) invoice[2]));
            invoiceDTO.setInvoiceDate((Date) invoice[3]);
            invoiceDTO.setPrice((BigDecimal) invoice[4]);
            invoiceDTO.setPaymentStatue(PaymentStatue.valueOf((String) invoice[5]));  // Assuming PaymentStatue is an enum
            invoiceDTO.setPaymentMethod(PaymentMethod.valueOf((String) invoice[6]));  // Assuming PaymentMethod is an enum
            invoiceDTO.setIdSyndic((Integer) invoice[7]);
            return invoiceDTO;
        }).collect(Collectors.toList());
    }

    public Resident authenticate(String phoneNumber, String password) {
        return residentRepository.findByPhoneNumberAndPassword(phoneNumber, password).orElse(null);
    }

    public Resident createResident(Resident resident){
        return residentRepository.save(resident);
    }

}

