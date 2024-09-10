package com.simplifia.Symplifia.repository;

import com.simplifia.Symplifia.dto.ResidentDTO;
import com.simplifia.Symplifia.models.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident,Integer> {

    @Query(value = "SELECT r.id_resident AS idResident, r.full_name AS fullName, r.phone_number AS phoneNumber, b.name AS buildingName " +
            "FROM resident r " +
            "JOIN building b ON r.id_building = b.id_building " +
            "WHERE b.id_syndic = :idSyndic", nativeQuery = true)
    List<Object[]> findResidentsBySyndic(@Param("idSyndic") Integer idSyndic);

    @Query(value = "SELECT i.id_invoice, i.invoice_month, i.invoice_year, i.invoice_date, i.price, i.payment_statue, i.payment_method, i.id_syndic " +
            "FROM invoice i " +
            "WHERE i.id_resident = :idResident AND i.invoice_year = :year", nativeQuery = true)
    List<Object[]> findInvoicesForResidentByYear(@Param("idResident") Integer idResident, @Param("year") Integer year);

    Optional<Resident> findByPhoneNumberAndPassword(String phoneNumber, String password);
}
