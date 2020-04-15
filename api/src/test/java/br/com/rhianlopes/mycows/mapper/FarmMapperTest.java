package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.edit.request.EditFarmRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rhian.costa
 */
@ExtendWith(MockitoExtension.class)
public class FarmMapperTest {

    @InjectMocks
    private FarmMapper farmMapper;

    @Test
    public void mapperToNewFarm_withSuccess() {

        final User user = Mockito.mock(User.class);
        final RegisterFarmRequestDto registerFarmRequestDto = Mockito.mock(RegisterFarmRequestDto.class);

        final Farm expectedFarm = new Farm()
                .setAddress(registerFarmRequestDto.getAddress())
                .setName(registerFarmRequestDto.getName())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setUser(user);

        final Farm resultFarm = farmMapper.mapperToNewFarm(user, registerFarmRequestDto);
        assertEquals(expectedFarm, resultFarm);
    }

    @Test
    public void mapperToEditFarm_withSuccess() {

        final EditFarmRequestDto editFarmRequestDto = Mockito.mock(EditFarmRequestDto.class);
        final Farm expectedFarm = new Farm()
                .setAddress(editFarmRequestDto.getAddress())
                .setName(editFarmRequestDto.getName())
                .setUpdatedAt(LocalDate.now());

        final Farm resultFarm = farmMapper.mapperToEditFarm(expectedFarm, editFarmRequestDto);
        assertEquals(expectedFarm, resultFarm);
    }
}