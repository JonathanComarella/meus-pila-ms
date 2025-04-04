package com.jcomarella.meuspilams.service;

import com.jcomarella.meuspilams.dto.ExpenseDto;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {

    ExpenseDto create(ExpenseDto expenseDto);

    void delete(UUID id);

    List<ExpenseDto> findAll();
}
