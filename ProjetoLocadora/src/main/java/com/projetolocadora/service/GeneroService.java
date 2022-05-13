package com.projetolocadora.service;

import com.projetolocadora.dto.GeneroDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneroService {
    Page<GeneroDto> listarGeneros(Pageable paginacao);
}
