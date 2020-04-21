package br.com.rhianlopes.mycows.service.cow;

import br.com.rhianlopes.mycows.controller.edit.request.EditCowRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.exception.CowNotFoundException;
import br.com.rhianlopes.mycows.exception.UserForbiddenException;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        assertEquals(expectedCow, resultCow);
    }

    @Test
    public void editCow_withSuccess() {

        final Long userId = 1L;
        final Cow expectedCow = mockCowWithUserId(userId);
        final EditCowRequestDto requestDto = Mockito.mock(EditCowRequestDto.class);

        given(cowRepository.findById(requestDto.getId()))
                .willReturn(Optional.of(expectedCow));

        given(cowMapper.mapperToEditCow(expectedCow, requestDto))
                .willReturn(expectedCow);

        given(cowRepository.save(expectedCow))
                .willReturn(expectedCow);

        final Cow resultCow = cowService.editCow(userId, requestDto);
        assertEquals(expectedCow, resultCow);
    }

    @Test
    public void findCowByIdAndUserId_withSuccess() {

        final Long cowId = 1L;
        final Long userId = 1L;
        final Cow expectedCow = mockCowWithUserId(userId);

        given(cowRepository.findById(cowId))
                .willReturn(Optional.of(expectedCow));

        final Cow resultCow = cowService.findCowByIdAndUserId(cowId, userId);
        assertEquals(expectedCow, resultCow);
    }

    @Test
    public void findCowByIdAndUserId_withCowNotFound_withException() {

        final String expectedMessage = "Cow Not Found!";
        final Long cowId = 1l;
        final Long userId = 1L;

        given(cowRepository.findById(cowId))
                .willReturn(Optional.empty());

        Throwable throwable = assertThrows(CowNotFoundException.class, () ->
                cowService.findCowByIdAndUserId(cowId, userId));
        assertEquals(expectedMessage, throwable.getMessage());
    }

    @Test
    public void findCowByIdAndUserId_withUserForbidden_withException() {

        final Long cowId = 1L;
        final Long userId = 1L;
        final Long wrongUserId = 2L;
        final Cow expectedCow = mockCowWithUserId(wrongUserId);
        final String expectedMessage = "User Forbidden!";

        given(cowRepository.findById(cowId))
                .willReturn(Optional.of(expectedCow));

        Throwable throwable = assertThrows(UserForbiddenException.class, () ->
                cowService.findCowByIdAndUserId(cowId, userId));
        assertEquals(expectedMessage, throwable.getMessage());
    }

    @Test
    public void findAllByFarmIdAndUserIdAndIsActive_withSuccess() {

        final Long farmId = 1L;
        final Long userId = 1L;
        final Boolean isActive = true;
        final Farm farm = Mockito.mock(Farm.class);
        final Cow cow = Mockito.mock(Cow.class);
        final List<Cow> expectedCowList = Collections.singletonList(cow);

        given(farmService.findByIdAndUserId(userId, farmId))
                .willReturn(farm);

        given(cowRepository.findAllByFarmAndIsActive(farm, isActive))
                .willReturn(expectedCowList);

        final List<Cow> resultCowList = cowService.findAllByFarmIdAndUserIdAndIsActive(farmId, userId, isActive);
        assertEquals(expectedCowList, resultCowList);
    }

    @Test
    public void archiveCowByIdAndUserId_withSuccess() {

        final Long cowId = 1L;
        final Long userId = 1L;
        final Cow expectedCow = mockCowWithUserId(userId)
                .setIsActive(true);

        given(cowRepository.findById(cowId))
                .willReturn(Optional.of(expectedCow));

        given(cowRepository.save(expectedCow))
                .willReturn(expectedCow);

        final Cow resultCow = cowService.archiveCowByIdAndUserId(cowId, userId);
        assertFalse(resultCow.getIsActive());
        assertEquals(expectedCow, resultCow);
    }

    private Cow mockCowWithUserId(Long userId) {
        final User user = new User().setId(userId);

        final Farm farm = new Farm().setUser(user);

        return new Cow().setFarm(farm);
    }
}