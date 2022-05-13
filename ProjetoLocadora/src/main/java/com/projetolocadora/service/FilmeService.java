package com.projetolocadora.service;

import com.projetolocadora.dto.FilmeDto;
import com.projetolocadora.dto.FilmeFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface FilmeService {

    Page<FilmeDto> listarFilmes(Pageable paginacao);
    URI inserir(FilmeFormDto filmeFormDto);
}
