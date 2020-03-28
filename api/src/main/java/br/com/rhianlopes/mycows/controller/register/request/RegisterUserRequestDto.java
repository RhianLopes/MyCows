package br.com.rhianlopes.mycows.controller.register.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisterUserRequestDto {

    @Email
    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    @Size(max = 512)
    private String password;

    @NotNull
    @Size(max = 30)
    private String phone;
}
