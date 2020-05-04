package br.com.rhianlopes.mycows.service.milk;

import br.com.rhianlopes.mycows.controller.edit.request.EditMilkRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterMilkRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Milk;
import br.com.rhianlopes.mycows.exception.MilkNotFoundException;
import br.com.rhianlopes.mycows.exception.UserForbiddenException;
import br.com.rhianlopes.mycows.mapper.MilkMapper;
import br.com.rhianlopes.mycows.repository.MilkRepository;
import br.com.rhianlopes.mycows.service.cow.CowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public Milk editMilk(Long userId, EditMilkRequestDto requestDto) {

        final Milk outdatedMilk = findByMilkIdAndUserId(requestDto.getId(), userId);

        final Milk milk = milkMapper.mapperToEditMilk(outdatedMilk, requestDto);

        return milkRepository.save(milk);
    }

    @Override
    public Milk findByMilkIdAndUserId(Long milkId, Long userId) {

        final Milk milk = milkRepository.findById(milkId)
                .orElseThrow(() -> new MilkNotFoundException("Milk Not Found!"));

        if (!userId.equals(milk.getCow().getFarm().getUser().getId())) {
            throw new UserForbiddenException("User Forbidden!");
        }

        return milk;
    }

    @Override
    public List<Milk> findAllByFilter(LocalDate initialDate, LocalDate finalDate) {
        return null;
    }

}
