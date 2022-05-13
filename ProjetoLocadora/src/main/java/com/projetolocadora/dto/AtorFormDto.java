package com.projetolocadora.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetolocadora.constants.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtorFormDto {

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotEmpty(message = "O campo nome não pode ser vazio")
    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    private LocalDate nascimento;

    private LocalDate morte;

    @NotNull(message = "O campo bio não pode ser nulo")
    @NotEmpty(message = "O campo bio não pode ser vazio")
    @NotBlank(message = "O campo bio não pode estar em branco")
    private String bio;

    private Sexo sexo;
}
