package br.com.rhianlopes.mycows.service.farm;

import br.com.rhianlopes.mycows.controller.edit.request.EditFarmRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;

import java.util.List;

/**
 * @author rhian.costa
 */
public interface FarmService {

    Farm registerFarm(Long userId, RegisterFarmRequestDto registerFarmRequestDto);

    Farm editFarm(Long userId, EditFarmRequestDto editFarmRequestDto);

    Farm findByIdAndUserId(Long userId, Long id);

    List<Farm> findAllByUserId(Long userId);

}
