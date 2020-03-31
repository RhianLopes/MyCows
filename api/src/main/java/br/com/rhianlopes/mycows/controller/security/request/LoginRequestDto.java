package br.com.rhianlopes.mycows.controller.security.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoginRequestDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
