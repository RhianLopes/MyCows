package br.com.rhianlopes.mycows.service.cow;

import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.mapper.CowMapper;
import br.com.rhianlopes.mycows.repository.CowRepository;
import br.com.rhianlopes.mycows.service.farm.FarmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * @author rhian.costa
 */
@ExtendWith(MockitoExtension.class)
public class CowServiceImplTest {

    @InjectMocks
    private CowServiceImpl cowService;

    @Mock
    private CowRepository cowRepository;

    @Mock
    private FarmService farmService;

    @Mock
    private CowMapper cowMapper;

    @Test
    public void registerCow_withSuccess() {

        final Farm farm = Mockito.mock(Farm.class);
        final Cow expectedCow = Mockito.mock(Cow.class);
        final RegisterCowRequestDto requestDto = Mockito.mock(RegisterCowRequestDto.class);
        final Long userId = 1L;

        given(farmService.findByIdAndUserId(userId, requestDto.getFarmId()))
                .willReturn(farm);

        given(cowMapper.mapperToNewCow(farm, requestDto))
                .willReturn(expectedCow);

        given(cowRepository.save(expectedCow))
                .willReturn(expectedCow);

        final Cow resultCow = cowService.registerCow(userId, requestDto);
        Assertions.assertEquals(expectedCow, resultCow);
    }

    @Test
    public void editCow() {
    }

    @Test
    public void findCowByIdAndUserId() {
    }

    @Test
    public void findAllByFarmIdAndUserIdAndIsActive() {
    }
}