package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.edit.request.EditMilkRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterMilkRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Milk;

import java.time.LocalDateTime;

/**
 * @author rhian.costa
 */
public class MilkMapper {

    public Milk mapperToNewMilk(Cow cow, RegisterMilkRequestDto requestDto) {
        return new Milk()
                .setDescription(requestDto.getDescription())
                .setLitters(requestDto.getLiters())
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now())
                .setCow(cow);
    }

    public Milk mapperToEditMilk(Milk milk, EditMilkRequestDto requestDto) {
        return milk
                .setDescription(requestDto.getDescription())
                .setLitters(requestDto.getLiters())
                .setUpdatedAt(LocalDateTime.now());
    }
}
