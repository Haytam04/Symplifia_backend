package com.simplifia.Symplifia.repository;

import com.simplifia.Symplifia.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.Date;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    Invoice findByResident_idResidentAndInvoiceMonthAndInvoiceYear(Integer residentId, Month  invoiceMonth, Year invoiceYear);

    @Query("SELECT SUM(i.price) FROM Invoice i WHERE i.invoiceDate BETWEEN :startDate AND :endDate AND i.syndic.idSyndic = :idSyndic AND paymentStatue=Payed")
    BigDecimal findTotalInvoicePriceBetweenDates(@Param("startDate") Date startDate,
                                                @Param("endDate") Date endDate,
                                                @Param("idSyndic") Integer idSyndic
                                                );
    }
