package br.com.rhianlopes.mycows.service.farm;

import br.com.rhianlopes.mycows.controller.edit.request.EditFarmRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.exception.FarmNotFoundException;
import br.com.rhianlopes.mycows.exception.UserForbiddenException;
import br.com.rhianlopes.mycows.mapper.FarmMapper;
import br.com.rhianlopes.mycows.repository.FarmRepository;
import br.com.rhianlopes.mycows.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

/**
 * @author rhian.costa
 */
@ExtendWith(MockitoExtension.class)
public class FarmServiceImplTest {

    @InjectMocks
    private FarmServiceImpl farmService;

    @Mock
    private FarmRepository farmRepository;

    @Mock
    private UserService userService;

    @Mock
    private FarmMapper farmMapper;

    @Test
    public void registerFarm_withSuccess() {

        final RegisterFarmRequestDto registerFarmRequestDto = Mockito.mock(RegisterFarmRequestDto.class);
        final User user = Mockito.mock(User.class);
        final Farm expectedFarm = Mockito.mock(Farm.class);
        final Long userId = 1L;

        given(userService.findById(userId))
                .willReturn(user);

        given(farmMapper.mapperToNewFarm(user, registerFarmRequestDto))
                .willReturn(expectedFarm);

        given(farmRepository.save(expectedFarm))
                .willReturn(expectedFarm);

        final Farm resultFarm = farmService.registerFarm(userId, registerFarmRequestDto);
        assertEquals(expectedFarm, resultFarm);
    }

    @Test
    public void editFarm_withSuccess() {

        final EditFarmRequestDto editFarmRequestDto = Mockito.mock(EditFarmRequestDto.class);
        final Long userId = 1L;
        final User user = new User()
                .setId(userId);
        final Farm expectedFarm = new Farm()
                .setUser(user);

        given(farmRepository.findById(editFarmRequestDto.getId()))
                .willReturn(Optional.of(expectedFarm));

        given(farmMapper.mapperToEditFarm(expectedFarm, editFarmRequestDto))
                .willReturn(expectedFarm);

        given(farmRepository.save(expectedFarm))
                .willReturn(expectedFarm);

        final Farm resultFarm = farmService.editFarm(userId, editFarmRequestDto);
        assertEquals(expectedFarm, resultFarm);
    }

    @Test
    public void findById_withSuccess() {

        final Long userId = 1L;
        final Long id = 1L;

        final User user = new User()
                .setId(userId);

        final Farm expectedFarm = new Farm()
                .setUser(user);

        given(farmRepository.findById(id))
                .willReturn(Optional.of(expectedFarm));

        final Farm resultFarm = farmService.findByIdAndUserId(userId, id);
        assertEquals(expectedFarm, resultFarm);
    }

    @Test
    public void findById_withUserForbidden_withException() {

        final String expectedMessage = "User Forbidden!";
        final Long userId = 1L;
        final Long id = 1L;

        final User user = Mockito.mock(User.class);
        final Farm expectedFarm = new Farm()
                .setUser(user);

        given(farmRepository.findById(id))
                .willReturn(Optional.of(expectedFarm));

        final Throwable throwable = assertThrows(UserForbiddenException.class, () ->
            farmService.findByIdAndUserId(userId, id));
        assertEquals(expectedMessage, throwable.getMessage());
    }

    @Test
    public void findById_withFarmNotFound_withException() {

        final String expectedMessage = "Farm Not Found!";
        final Long userId = 1L;
        final Long id = 1L;

        given(farmRepository.findById(id))
                .willReturn(Optional.empty());

        final Throwable throwable = assertThrows(FarmNotFoundException.class, () ->
                farmService.findByIdAndUserId(userId, id));
        assertEquals(expectedMessage, throwable.getMessage());
    }

    @Test
    public void findAllByUserId_withSuccess() {

        final Farm farm = Mockito.mock(Farm.class);
        final List<Farm> expectedFarmList = Collections.singletonList(farm);
        final User user = Mockito.mock(User.class);
        final Long userId = 1L;

        given(userService.findById(userId))
                .willReturn(user);

        given(farmRepository.findAllByUser(user))
                .willReturn(expectedFarmList);

        final List<Farm> resultFarmList = farmService.findAllByUserId(userId);
        assertEquals(expectedFarmList, resultFarmList);
    }
}