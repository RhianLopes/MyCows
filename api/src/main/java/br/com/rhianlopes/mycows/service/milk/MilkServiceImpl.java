package br.com.rhianlopes.mycows.service.milk;

import br.com.rhianlopes.mycows.controller.register.request.RegisterMilkRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Milk;
import br.com.rhianlopes.mycows.mapper.MilkMapper;
import br.com.rhianlopes.mycows.repository.MilkRepository;
import br.com.rhianlopes.mycows.service.cow.CowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author rhian.costa
 */
@Service
@RequiredArgsConstructor
public class MilkServiceImpl implements MilkService {

    private final MilkRepository milkRepository;

    private final CowService cowService;

    private final MilkMapper milkMapper;

    @Override
    public Milk registerMilk(Long userId, RegisterMilkRequestDto requestDto) {

        final Cow cow = cowService.findCowByIdAndUserId(userId, requestDto.getCowId());

        final Milk milk = milkMapper.mapperToNewMilk(cow, requestDto);

        return milkRepository.save(milk);
    }

}
