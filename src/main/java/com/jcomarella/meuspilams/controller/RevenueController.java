package com.jcomarella.meuspilams.controller;

import com.jcomarella.meuspilams.dto.RevenueDto;
import com.jcomarella.meuspilams.service.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/revenue")
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @PostMapping
    public ResponseEntity<RevenueDto> createExpense(@RequestBody RevenueDto revenueDto) {
        RevenueDto revenue = revenueService.create(revenueDto);
        return new ResponseEntity<>(revenue, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RevenueDto> deleteExpense(@PathVariable UUID id) {
        revenueService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
