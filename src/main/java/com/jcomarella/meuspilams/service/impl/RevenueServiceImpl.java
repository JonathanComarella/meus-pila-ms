package com.jcomarella.meuspilams.service.impl;

import com.jcomarella.meuspilams.dto.RevenueDto;
import com.jcomarella.meuspilams.model.Revenue;
import com.jcomarella.meuspilams.repository.RevenueRepository;
import com.jcomarella.meuspilams.service.RevenueService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;

    public RevenueServiceImpl(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    @Override
    public RevenueDto create(RevenueDto revenueDto) {
        Revenue revenue = new Revenue(null, revenueDto.description(), revenueDto.amount(), revenueDto.dueDate());
        revenue = revenueRepository.save(revenue);
        revenueDto = new RevenueDto(revenue.getId(), revenue.getDescription(), revenue.getAmount(), revenue.getDueDate());
        return revenueDto;

    }

    @Override
    public void delete(UUID id) {
        revenueRepository.deleteById(id);
    }
}
