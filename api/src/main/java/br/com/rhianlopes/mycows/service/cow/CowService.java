package br.com.rhianlopes.mycows.service.cow;

import br.com.rhianlopes.mycows.controller.edit.request.EditCowRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;

import java.util.List;

/**
 * @author rhian.costa
 */
public interface CowService {

    Cow registerCow(Long userId, RegisterCowRequestDto registerCowRequestDto);

    Cow editCow(Long userId, EditCowRequestDto editCowRequestDto);

    Cow findCowByIdAndUserId(Long id, Long userId);

    List<Cow> findAllByFarmIdAndUserIdAndIsActive(Long farmId, Long userId, Boolean isActive);
}
