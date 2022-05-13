package com.projetolocadora.service;

import com.projetolocadora.dto.GeneroDto;
import com.projetolocadora.entities.Genero;
import com.projetolocadora.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<GeneroDto> listarGeneros(Pageable paginacao){
        Page<Genero> genero = generoRepository.findAll(paginacao);
        return new PageImpl<>(genero.stream().map(i-> mapper.map(i, GeneroDto.class)).toList());
    }
}
