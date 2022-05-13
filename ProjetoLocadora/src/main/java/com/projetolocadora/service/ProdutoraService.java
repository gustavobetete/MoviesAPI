package com.projetolocadora.service;

import com.projetolocadora.dto.ProdutoraDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoraService {
    Page<ProdutoraDto> listarProdutoras(Pageable paginacao);
}
