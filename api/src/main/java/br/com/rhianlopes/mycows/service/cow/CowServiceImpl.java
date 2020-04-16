package br.com.rhianlopes.mycows.service.cow;

import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.mapper.CowMapper;
import br.com.rhianlopes.mycows.repository.CowRepository;
import br.com.rhianlopes.mycows.service.farm.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author rhian.costa
 */
@Service
@RequiredArgsConstructor
public class CowServiceImpl implements CowService {

    private final CowRepository cowRepository;

    private final FarmService farmService;

    private final CowMapper cowMapper;

    @Override
    public Cow registerCow(Long userId, RegisterCowRequestDto requestDto) {

        final Farm farm = farmService.findByIdAndUserId(userId, requestDto.getFarmId());

        final Cow cow = cowMapper.mapperToNewCow(farm, requestDto);

        return cowRepository.save(cow);
    }
}
