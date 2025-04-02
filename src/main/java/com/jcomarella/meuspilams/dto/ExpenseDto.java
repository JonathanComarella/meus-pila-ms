package com.jcomarella.meuspilams.dto;

import com.jcomarella.meuspilams.utils.StatusExpense;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ExpenseDto(UUID id, String description, BigDecimal amount, LocalDateTime dueDate, StatusExpense status) {
}
