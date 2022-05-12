package com.projetolocadora.dto;

import com.projetolocadora.entities.Genero;
import com.projetolocadora.entities.Produtora;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDto {

    private Long id;
    private String titulo;
    private Time duracao;
    private Produtora produtoras;
    private List<Genero> generos;
    private String faixaEtaria;
}
