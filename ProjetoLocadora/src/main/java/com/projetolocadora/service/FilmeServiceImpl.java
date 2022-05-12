package com.projetolocadora.service;

import com.projetolocadora.dto.FilmeDto;
import com.projetolocadora.entities.Filme;
import com.projetolocadora.repository.FilmeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

}
