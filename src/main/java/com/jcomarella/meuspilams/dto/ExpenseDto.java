package com.jcomarella.meuspilams.dto;

import com.jcomarella.meuspilams.utils.StatusExpense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    private UUID id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime dueDate;
    private StatusExpense status;
}
