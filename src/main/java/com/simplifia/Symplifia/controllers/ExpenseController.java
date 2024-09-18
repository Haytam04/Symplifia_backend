package com.simplifia.Symplifia.controllers;

import com.simplifia.Symplifia.dto.ExpenseDTO;
import com.simplifia.Symplifia.models.Expense;
import com.simplifia.Symplifia.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/syndics/{syndicId}/expenses")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public List<ExpenseDTO> getExpensesBySyndicId(@PathVariable Integer syndicId) {
        return expenseService.getAllExpensesBySyndicId(syndicId);
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@PathVariable Integer syndicId, @RequestBody Expense expense) {
        ExpenseDTO expenseDTO = expenseService.createExpense(syndicId, expense);
        return ResponseEntity.ok(expenseDTO);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Integer expenseId, @PathVariable Integer syndicId, @RequestBody Expense expense) {
        ExpenseDTO updatedExpense = expenseService.updateExpense(expenseId, syndicId, expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Integer expenseId) {
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.noContent().build();
    }
}
