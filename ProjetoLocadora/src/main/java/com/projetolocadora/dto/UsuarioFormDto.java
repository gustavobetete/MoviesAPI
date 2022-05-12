package com.projetolocadora.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UsuarioFormDto {

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotEmpty(message = "O campo nome não pode ser vazio")
    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    @NotNull(message = "O campo email não pode ser nulo")
    @NotEmpty(message = "O campo email não pode ser vazio")
    @NotBlank(message = "O campo email não pode estar em branco")
    private String email;

    @NotNull(message = "O campo senha não pode ser nulo")
    @NotEmpty(message = "O campo senha não pode ser vazio")
    @NotBlank(message = "O campo senha não pode estar em branco")
    private String senha;

    @NotNull(message = "O campo dataNasc não pode ser nulo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR")
    private LocalDate dataNasc;

    @NotNull(message = "O campo validaCPF não pode ser nulo")
    @NotEmpty(message = "O campo validaCPF não pode ser vazio")
    @NotBlank(message = "O campo validaCPF não pode estar em branco")
    private String validaCPF;


}
