package br.com.rhianlopes.mycows.service.farm;

import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {
    @Override
    public Farm registerFarm(RegisterFarmRequestDto registerFarmRequestDto) {
        return null;
    }
}
