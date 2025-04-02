package com.jcomarella.meuspilams.controller;

import com.jcomarella.meuspilams.dto.ExpenseDto;
import com.jcomarella.meuspilams.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.create(expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseDto> deleteExpense(@PathVariable UUID id) {
        expenseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
