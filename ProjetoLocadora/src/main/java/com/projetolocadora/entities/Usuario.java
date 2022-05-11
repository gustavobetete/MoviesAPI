package com.projetolocadora.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNasc;
    private String validaCPF;
}
