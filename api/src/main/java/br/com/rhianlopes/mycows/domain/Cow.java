package br.com.rhianlopes.mycows.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author rhian.costa
 */
@Data
@Entity
@Accessors(chain = true)
public class Cow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String code;

    @NotNull
    @Size(max = 100)
    private String species;

    @Size(max = 500)
    private String description;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

    @NotNull
    private Boolean isActive;
}
