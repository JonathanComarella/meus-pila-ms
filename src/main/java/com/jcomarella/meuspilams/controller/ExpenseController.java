package com.jcomarella.meuspilams.controller;

import com.jcomarella.meuspilams.dto.ExpenseDto;
import com.jcomarella.meuspilams.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> create(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.create(expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAll() {
        List<ExpenseDto> expenses = expenseService.findAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseDto> delete(@PathVariable UUID id) {
        expenseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
