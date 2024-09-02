package com.simplifia.Symplifia.dto;

import com.simplifia.Symplifia.models.Expense;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class ExpenseDTO {
    private Integer idExpense;
    private String name;
    private BigDecimal cost;
    private String description;
    private Date date;

    public ExpenseDTO(Expense expense) {
        this.idExpense = expense.getIdExpense();
        this.name = expense.getName();
        this.cost = expense.getCost();
        this.description = expense.getDescription();
        this.date = expense.getDate();
    }
}
