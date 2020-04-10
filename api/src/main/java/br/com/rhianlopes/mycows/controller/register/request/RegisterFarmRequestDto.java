package br.com.rhianlopes.mycows.controller.register.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author rhian.costa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisterFarmRequestDto {

    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    @Size(max = 500)
    private String address;
}
