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
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    @Size(max = 500)
    private String address;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
}
