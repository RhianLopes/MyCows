package br.com.rhianlopes.mycows.service.milk;

import br.com.rhianlopes.mycows.controller.edit.request.EditMilkRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterMilkRequestDto;
import br.com.rhianlopes.mycows.domain.Milk;

public interface MilkService {

    Milk registerMilk(Long userId, RegisterMilkRequestDto registerMilkRequestDto);

    Milk editMilk(Long userId, EditMilkRequestDto editMilkRequestDto);

}
