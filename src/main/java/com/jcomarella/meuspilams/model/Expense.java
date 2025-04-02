package com.jcomarella.meuspilams.model;

import com.jcomarella.meuspilams.utils.StatusExpense;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    private StatusExpense status;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = StatusExpense.PENDING;
        }
    }
}
