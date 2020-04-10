package br.com.rhianlopes.mycows.mapper;

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
}
