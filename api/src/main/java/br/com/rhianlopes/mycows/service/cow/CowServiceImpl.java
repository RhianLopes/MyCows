package br.com.rhianlopes.mycows.service.cow;

import br.com.rhianlopes.mycows.controller.edit.request.EditCowRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.exception.CowNotFoundException;
import br.com.rhianlopes.mycows.exception.UserForbiddenException;
import br.com.rhianlopes.mycows.mapper.CowMapper;
import br.com.rhianlopes.mycows.repository.CowRepository;
import br.com.rhianlopes.mycows.service.farm.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Cow editCow(Long userId, EditCowRequestDto requestDto) {

        final Cow outdatedCow = findCowByIdAndUserId(requestDto.getId(), userId);

        final Cow cow = cowMapper.mapperToEditCow(outdatedCow, requestDto);

        return cowRepository.save(cow);
    }

    @Override
    public Cow findCowByIdAndUserId(Long cowId, Long userId) {

        final Cow cow = cowRepository.findById(cowId)
                .orElseThrow(() -> new CowNotFoundException("Cow Not Found!"));

        if (!userId.equals(cow.getFarm().getUser().getId())) {
            throw new UserForbiddenException("User Forbidden!");
        }

        return cow;
    }

    @Override
    public List<Cow> findAllByFarmIdAndUserIdAndIsActive(Long farmId, Long userId, Boolean isActive) {

        final Farm farm = farmService.findByIdAndUserId(userId, farmId);

        return cowRepository.findAllByFarmAndIsActive(farm, isActive);
    }

    @Override
    public Cow archiveCowByIdAndUserId(Long cowId, Long userId) {

        final Cow cow = findCowByIdAndUserId(cowId, userId);

        cow.setIsActive(!cow.getIsActive());

        return cowRepository.save(cow);
    }
}
