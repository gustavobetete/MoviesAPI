package com.projetolocadora.dto;

import com.projetolocadora.entities.Genero;
import com.projetolocadora.entities.Produtora;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.Year;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDto {

    private Long id;
    private String titulo;
    private Time duracao;
    private ProdutoraFilmeDto produtoras;
    private List<GeneroFilmeDto> generos;
    private String faixaEtaria;
    private Long anoLancamento;
}
