package br.com.rhianlopes.mycows.service.farm;

import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;

public interface FarmService {

    Farm registerFarm(RegisterFarmRequestDto registerFarmRequestDto);
}
