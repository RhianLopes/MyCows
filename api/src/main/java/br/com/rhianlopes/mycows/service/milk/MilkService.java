package br.com.rhianlopes.mycows.service.milk;

import br.com.rhianlopes.mycows.controller.edit.request.EditMilkRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterMilkRequestDto;
import br.com.rhianlopes.mycows.domain.Milk;

import java.time.LocalDate;
import java.util.List;

public interface MilkService {

    Milk registerMilk(Long userId, RegisterMilkRequestDto registerMilkRequestDto);

    Milk editMilk(Long userId, EditMilkRequestDto editMilkRequestDto);

    Milk findByMilkIdAndUserId(Long milkId, Long userId);

    List<Milk> findAllByFilter(Long userId, LocalDate initialDate, LocalDate finalDate);

}
