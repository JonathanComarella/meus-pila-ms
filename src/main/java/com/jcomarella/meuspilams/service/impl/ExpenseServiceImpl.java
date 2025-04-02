package com.jcomarella.meuspilams.service.impl;

import com.jcomarella.meuspilams.dto.ExpenseDto;
import com.jcomarella.meuspilams.model.Expense;
import com.jcomarella.meuspilams.repository.ExpenseRepository;
import com.jcomarella.meuspilams.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseDto create(ExpenseDto expenseDto) {
        Expense expense = new Expense(null, expenseDto.description(), expenseDto.amount(), expenseDto.dueDate(), null);
        expense = expenseRepository.save(expense);
        expenseDto = new ExpenseDto(expense.getId(), expense.getDescription(), expense.getAmount(), expense.getDueDate(), expense.getStatus());
        return expenseDto;

    }

    @Override
    public void delete(UUID id) {
        expenseRepository.deleteById(id);
    }
}
