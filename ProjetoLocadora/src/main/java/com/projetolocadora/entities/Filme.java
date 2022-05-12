package com.projetolocadora.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Time duracao;

    @ManyToOne
    @JoinColumn(name = "produtora_id")
    private Produtora produtoras;

    @OneToMany(mappedBy = "filme")
    private List<Ator> ator = new ArrayList<>();

    @OneToMany(mappedBy = "filme")
    private List<Genero> generos;

    private String faixaEtaria;

    private Long anoLancamento;
}
