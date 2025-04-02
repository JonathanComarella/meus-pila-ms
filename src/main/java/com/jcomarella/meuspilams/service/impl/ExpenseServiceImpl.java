package com.jcomarella.meuspilams.service.impl;

import com.jcomarella.meuspilams.dto.ExpenseDto;
import com.jcomarella.meuspilams.model.Expense;
import com.jcomarella.meuspilams.repository.ExpenseRepository;
import com.jcomarella.meuspilams.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ModelMapper modelMapper) {
        this.expenseRepository = expenseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExpenseDto create(ExpenseDto expenseDto) {
        Expense expense = modelMapper.map(expenseDto, Expense.class);
        expense = expenseRepository.save(expense);
        expenseDto = modelMapper.map(expense, ExpenseDto.class);
        return expenseDto;

    }

    @Override
    public void delete(UUID id) {
        expenseRepository.deleteById(id);
    }
}
