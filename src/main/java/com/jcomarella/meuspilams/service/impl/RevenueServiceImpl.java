package com.jcomarella.meuspilams.service.impl;

import com.jcomarella.meuspilams.dto.RevenueDto;
import com.jcomarella.meuspilams.model.Revenue;
import com.jcomarella.meuspilams.repository.RevenueRepository;
import com.jcomarella.meuspilams.service.RevenueService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;
    private final ModelMapper modelMapper;

    public RevenueServiceImpl(RevenueRepository revenueRepository, ModelMapper modelMapper) {
        this.revenueRepository = revenueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RevenueDto create(RevenueDto revenueDto) {
        Revenue revenue = modelMapper.map(revenueDto, Revenue.class);
        revenue = revenueRepository.save(revenue);
        revenueDto = modelMapper.map(revenue, RevenueDto.class);
        return revenueDto;

    }

    @Override
    public void delete(UUID id) {
        revenueRepository.deleteById(id);
    }
}
