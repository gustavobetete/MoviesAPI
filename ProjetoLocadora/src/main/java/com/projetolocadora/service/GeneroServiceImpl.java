package com.projetolocadora.service;

import com.projetolocadora.dto.GeneroDto;
import com.projetolocadora.dto.GeneroFormDto;
import com.projetolocadora.entities.Genero;
import com.projetolocadora.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @Override
    public URI inserir(GeneroFormDto generoFormDto) {
        Genero genero = mapper.map(generoFormDto, Genero.class);
        generoRepository.save(genero);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(genero.getId()).toUri();
        return uri;
    }
}
