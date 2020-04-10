package br.com.rhianlopes.mycows.service.farm;

import br.com.rhianlopes.mycows.controller.edit.request.EditFarmRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.exception.FarmNotFoundException;
import br.com.rhianlopes.mycows.mapper.FarmMapper;
import br.com.rhianlopes.mycows.repository.FarmRepository;
import br.com.rhianlopes.mycows.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author rhian.costa
 */
@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    private final UserService userService;

    private final FarmMapper farmMapper;

    @Override
    public Farm registerFarm(Long userId, RegisterFarmRequestDto registerFarmRequestDto) {

        final User user = userService.findById(userId);

        final Farm farm = farmMapper.mapperToNewFarm(user, registerFarmRequestDto);

        return farmRepository.save(farm);
    }

    @Override
    public Farm editFarm(EditFarmRequestDto editFarmRequestDto) {

        final Farm outdatedFarm = farmRepository.findById(editFarmRequestDto.getId())
                .orElseThrow(() -> new FarmNotFoundException("Farm Not Found!"));

        final Farm farm = farmMapper.mapperToEditFarm(outdatedFarm, editFarmRequestDto);

        return farmRepository.save(farm);
    }
}
