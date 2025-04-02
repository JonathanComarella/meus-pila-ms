package com.jcomarella.meuspilams.service;

import com.jcomarella.meuspilams.dto.RevenueDto;

import java.util.List;
import java.util.UUID;

public interface RevenueService {

    RevenueDto create(RevenueDto revenueDto);

    void delete(UUID id);

    List<RevenueDto> findAll();
}
