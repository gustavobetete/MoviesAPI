package com.projetolocadora.service;

import com.projetolocadora.dto.FilmeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmeService {

    Page<FilmeDto> listarFilmes(Pageable paginacao);
}
