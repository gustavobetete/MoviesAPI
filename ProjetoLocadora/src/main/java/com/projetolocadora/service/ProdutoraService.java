package com.projetolocadora.service;

import com.projetolocadora.dto.ProdutoraDto;
import com.projetolocadora.dto.ProdutoraFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface ProdutoraService {
    Page<ProdutoraDto> listarProdutoras(Pageable paginacao);

    URI inserir(ProdutoraFormDto produtoraFormDto);
}
