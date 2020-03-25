package br.com.rhianlopes.mycows.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Accessors(chain = true)
public class User {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
}