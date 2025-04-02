package com.jcomarella.meuspilams.service;

import com.jcomarella.meuspilams.dto.RevenueDto;
import com.jcomarella.meuspilams.model.Revenue;
import com.jcomarella.meuspilams.repository.RevenueRepository;
import com.jcomarella.meuspilams.service.impl.RevenueServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RevenueServiceImplTest {

    @Mock
    private RevenueRepository revenueRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RevenueServiceImpl revenueService;

    @Test
    void testCreateRevenue() {
        RevenueDto revenueDto = new RevenueDto();
        revenueDto.setId(UUID.randomUUID());
        revenueDto.setAmount(new BigDecimal("100.00"));
        revenueDto.setDescription("Test Revenue");

        Revenue revenue = new Revenue();
        revenue.setDescription("Test Revenue");
        revenue.setAmount(new BigDecimal("100.00"));

        when(modelMapper.map(revenueDto, Revenue.class)).thenReturn(revenue);
        when(revenueRepository.save(revenue)).thenReturn(revenue);
        when(modelMapper.map(revenue, RevenueDto.class)).thenReturn(revenueDto);

        RevenueDto result = revenueService.create(revenueDto);

        assertNotNull(result);
        assertEquals("Test Revenue", result.getDescription());
        assertEquals(new BigDecimal("100.00"), result.getAmount());

        verify(modelMapper).map(revenueDto, Revenue.class);
        verify(revenueRepository).save(revenue);
        verify(modelMapper).map(revenue, RevenueDto.class);
    }

    @Test
    void testFindAllRevenues() {
        List<Revenue> revenues = Arrays.asList(new Revenue(), new Revenue(), new Revenue());

        when(revenueRepository.findAll()).thenReturn(revenues);

        List<RevenueDto> revenuesDtos = revenueService.findAll();

        assertNotNull(revenuesDtos);
        assertEquals(revenuesDtos.size(), revenues.size());
    }

    @Test
    void testDeleteRevenue() {
        UUID revenueId = UUID.randomUUID();
        revenueService.delete(revenueId);

        verify(revenueRepository).deleteById(revenueId);
    }
}
