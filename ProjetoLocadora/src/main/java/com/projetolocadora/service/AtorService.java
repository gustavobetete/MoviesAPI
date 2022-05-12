package com.projetolocadora.service;

import com.projetolocadora.dto.AtorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface AtorService {

    Page<AtorDto> listarAtores(Pageable paginacao);
}
