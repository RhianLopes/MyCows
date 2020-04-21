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
        final User user = new User()
                .setId(userId);
        final Farm farm = new Farm()
                .setUser(user);
        final Cow expectedCow = new Cow()
                .setFarm(farm);
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
    public void editCow_withCowNotFound_withException() {

        final String expectedMessage = "Cow Not Found!";
        final EditCowRequestDto requestDto = Mockito.mock(EditCowRequestDto.class);
        final Long userId = 1L;

        given(cowRepository.findById(requestDto.getId()))
                .willReturn(Optional.empty());

        Throwable throwable = assertThrows(CowNotFoundException.class, () ->
                cowService.editCow(userId, requestDto));
        assertEquals(expectedMessage, throwable.getMessage());
    }

    @Test
    public void editCow_withUserForbidden_withException() {

        final Long userId = 1L;
        final Long wrongUserId = 2L;
        final User user = new User()
                .setId(wrongUserId);
        final Farm farm = new Farm()
                .setUser(user);
        final Cow expectedCow = new Cow()
                .setFarm(farm);
        final EditCowRequestDto requestDto = Mockito.mock(EditCowRequestDto.class);
        final String expectedMessage = "User Forbidden!";

        given(cowRepository.findById(requestDto.getId()))
                .willReturn(Optional.of(expectedCow));

        Throwable throwable = assertThrows(UserForbiddenException.class, () ->
                cowService.editCow(userId, requestDto));
        assertEquals(expectedMessage, throwable.getMessage());
    }

    @Test
    public void findCowByIdAndUserId() {
    }

    @Test
    public void findAllByFarmIdAndUserIdAndIsActive() {
    }
}