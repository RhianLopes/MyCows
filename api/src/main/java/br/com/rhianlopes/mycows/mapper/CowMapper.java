package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.edit.request.EditCowRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CowMapper {

    public Cow mapperToNewCow(Farm farm, RegisterCowRequestDto registerCowRequestDto) {
        return new Cow()
                .setDescription(registerCowRequestDto.getDescription())
                .setSpecies(registerCowRequestDto.getSpecies())
                .setName(registerCowRequestDto.getName())
                .setCode(registerCowRequestDto.getCode())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setIsActive(true)
                .setFarm(farm);
    }

    public Cow mapperToEditCow(Cow cow, EditCowRequestDto editCowRequestDto) {
        return cow
                .setDescription(editCowRequestDto.getDescription())
                .setSpecies(editCowRequestDto.getSpecies())
                .setName(editCowRequestDto.getName())
                .setCode(editCowRequestDto.getCode())
                .setUpdatedAt(LocalDate.now());
    }
}
