package com.projetolocadora.service;

import com.projetolocadora.dto.AtorDto;
import com.projetolocadora.dto.AtorFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URI;


public interface AtorService {

    Page<AtorDto> listarAtores(Pageable paginacao);
    URI inserir(AtorFormDto atorFormDto);
}
