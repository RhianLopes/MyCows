package br.com.rhianlopes.mycows.controller.find.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author rhian.costa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FindAllMilkFilterRequestDto {

    @NotNull
    private Long cowId;

    private LocalDate initialDate;

    private LocalDate finalDate;
}
