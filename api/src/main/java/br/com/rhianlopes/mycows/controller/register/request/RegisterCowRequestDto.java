package br.com.rhianlopes.mycows.controller.register.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisterCowRequestDto {

    @NotNull
    private Long farmId;

    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String code;

    @NotNull
    @Size(max = 200)
    private String species;

    @Size(max = 500)
    private String description;
}
