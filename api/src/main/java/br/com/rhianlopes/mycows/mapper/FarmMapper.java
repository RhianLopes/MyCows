package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.edit.request.EditFarmRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author rhian.costa
 */
@Component
public class FarmMapper {

    public Farm mapperToNewFarm(User user, RegisterFarmRequestDto registerFarmRequestDto) {
        return new Farm()
                .setAddress(registerFarmRequestDto.getAddress())
                .setName(registerFarmRequestDto.getName())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setUser(user);
    }

    public Farm mapperToEditFarm(Farm farm, EditFarmRequestDto editFarmRequestDto) {
        return farm
                .setAddress(editFarmRequestDto.getAddress())
                .setName(editFarmRequestDto.getName())
                .setUpdatedAt(LocalDate.now());
    }
}
