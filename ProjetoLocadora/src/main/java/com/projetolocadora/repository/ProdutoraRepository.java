package com.projetolocadora.repository;

import com.projetolocadora.entities.Produtora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoraRepository extends JpaRepository<Produtora, Long> {

    Optional<Produtora> findByNome(String nome);

}
