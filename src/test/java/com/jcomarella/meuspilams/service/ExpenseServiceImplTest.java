package com.jcomarella.meuspilams.service;

import com.jcomarella.meuspilams.dto.ExpenseDto;
import com.jcomarella.meuspilams.model.Expense;
import com.jcomarella.meuspilams.repository.ExpenseRepository;
import com.jcomarella.meuspilams.service.impl.ExpenseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceImplTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Test
    void testCreateExpense() {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setDescription("Test Expense");
        expenseDto.setAmount(new BigDecimal("100.00"));

        Expense expense = new Expense();
        expense.setDescription("Test Expense");
        expense.setAmount(new BigDecimal("100.00"));

        when(modelMapper.map(expenseDto, Expense.class)).thenReturn(expense);
        when(expenseRepository.save(expense)).thenReturn(expense);
        when(modelMapper.map(expense, ExpenseDto.class)).thenReturn(expenseDto);

        ExpenseDto result = expenseService.create(expenseDto);

        assertNotNull(result);
        assertEquals("Test Expense", result.getDescription());
        assertEquals(new BigDecimal("100.00"), result.getAmount());

        verify(modelMapper).map(expenseDto, Expense.class);
        verify(expenseRepository).save(expense);
        verify(modelMapper).map(expense, ExpenseDto.class);
    }

    @Test
    void testFindAllExpenses() {
        List<Expense> expenses = Arrays.asList(new Expense(), new Expense(), new Expense());

        when(expenseRepository.findAll()).thenReturn(expenses);

        List<ExpenseDto> expenseDtos = expenseService.findAll();

        assertNotNull(expenseDtos);
        assertEquals(expenseDtos.size(), expenses.size());
    }

    @Test
    void testDeleteExpense() {
        UUID expenseId = UUID.randomUUID();
        expenseService.delete(expenseId);

        verify(expenseRepository).deleteById(expenseId);
    }
}
