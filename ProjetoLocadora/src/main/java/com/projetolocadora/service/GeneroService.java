package com.projetolocadora.service;

import com.projetolocadora.dto.GeneroDto;
import com.projetolocadora.dto.GeneroFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface GeneroService {
    Page<GeneroDto> listarGeneros(Pageable paginacao);
    URI inserir(GeneroFormDto generoFormDto);
}
