package br.com.rhianlopes.mycows.service.farm;

import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;

/**
 * @author rhian.costa
 */
public interface FarmService {

    Farm registerFarm(Long userId, RegisterFarmRequestDto registerFarmRequestDto);
}
