package com.projetolocadora.repository;

import com.projetolocadora.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

    Optional<Genero> findByNome(String nome);
}
