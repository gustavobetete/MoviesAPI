package com.projetolocadora.service;

import com.projetolocadora.dto.FilmeDto;
import com.projetolocadora.dto.FilmeFormDto;
import com.projetolocadora.entities.Filme;
import com.projetolocadora.repository.FilmeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeServiceImpl implements FilmeService{

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<FilmeDto> listarFilmes(Pageable paginacao) {
        Page<Filme> filmes = filmeRepository.findAll(paginacao);
        return new PageImpl<>(filmes.stream().map(i -> mapper.map(i, FilmeDto.class)).toList());
    }

    @Override
    public URI inserir(FilmeFormDto filmeFormDto) {
        Filme filme = mapper.map(filmeFormDto, Filme.class);
        filmeRepository.save(filme);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId()).toUri();
        return uri;
    }

}
