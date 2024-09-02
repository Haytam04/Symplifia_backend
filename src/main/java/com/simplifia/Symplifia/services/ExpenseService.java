package com.simplifia.Symplifia.services;


import com.simplifia.Symplifia.dto.ExpenseDTO;
import com.simplifia.Symplifia.models.Expense;
import com.simplifia.Symplifia.models.Syndic;
import com.simplifia.Symplifia.repository.ExpenseRepository;
import com.simplifia.Symplifia.repository.SyndicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final SyndicRepository syndicRepository;

    public List<ExpenseDTO> getAllExpensesBySyndicId(Integer syndicId) {
        return expenseRepository.findBySyndic_IdSyndic(syndicId)
                .stream()
                .map(ExpenseDTO::new)
                .collect(Collectors.toList());
    }

    public Expense getExpenseById(Integer expenseId) {
        return expenseRepository.findById(expenseId).orElse(null);
    }

    public ExpenseDTO createExpense(Integer syndicId, Expense expense) {
        Syndic syndic = syndicRepository.findById(syndicId).orElse(null);
        expense.setSyndic(syndic);
        Expense savedExpense = expenseRepository.save(expense);
        return new ExpenseDTO(savedExpense);
    }

    public ExpenseDTO updateExpense(Integer expenseId, Integer syndicId, Expense updatedExpense) {
        Expense existingExpense = expenseRepository.findById(expenseId).orElse(null);
        Syndic relatedSyndic = syndicRepository.findById(syndicId).orElse(null);

        existingExpense.setName(updatedExpense.getName());
        existingExpense.setCost(updatedExpense.getCost());
        existingExpense.setDescription(updatedExpense.getDescription());
        existingExpense.setDate(updatedExpense.getDate());
        existingExpense.setSyndic(relatedSyndic);

        Expense savedExpense = expenseRepository.save(existingExpense);
        return new ExpenseDTO(savedExpense);
    }

    public void deleteExpense(Integer expenseId) {
        expenseRepository.deleteById(expenseId);
    }
}
