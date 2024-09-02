package com.simplifia.Symplifia.repository;

import com.simplifia.Symplifia.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    List<Expense> findBySyndic_IdSyndic(Integer syndicId);

    @Query("SELECT SUM(e.cost) FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate AND e.syndic.idSyndic = :syndicId")
    BigDecimal findTotalExpenseCostBetweenDates(@Param("startDate") Date startDate,
                                                @Param("endDate") Date endDate,
                                                @Param("syndicId") Integer syndicId);
    }
