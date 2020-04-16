package br.com.rhianlopes.mycows.service.cow;

import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;

/**
 * @author rhian.costa
 */
public interface CowService {

    Cow registerCow(Long userId, RegisterCowRequestDto registerCowRequestDto);
}
