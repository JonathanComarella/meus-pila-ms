package com.jcomarella.meuspilams.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RevenueDto(UUID id, String description, BigDecimal amount, LocalDateTime dueDate) {
}
