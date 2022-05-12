package com.projetolocadora.dto;

import com.projetolocadora.entities.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeFormDto {

    @NotNull(message = "O campo titulo não pode ser nulo")
    @NotEmpty(message = "O campo titulo não pode ser vazio")
    @NotBlank(message = "O campo titulo não pode estar em branco")
    private String titulo;

    @NotNull(message = "O campo duracao não pode ser nulo")
    private Time duracao;

    @NotNull(message = "O campo NomeProdutora não pode ser nulo")
    @NotEmpty(message = "O campo NomeProdutora não pode ser vazio")
    @NotBlank(message = "O campo NomeProdutora não pode estar em branco")
    private String NomeProdutora;

    private List<Genero> generos;

    @NotNull(message = "O campo faixaEtaria não pode ser nulo")
    @NotEmpty(message = "O campo faixaEtaria não pode ser vazio")
    @NotBlank(message = "O campo faixaEtaria não pode estar em branco")
    private String faixaEtaria;
}
