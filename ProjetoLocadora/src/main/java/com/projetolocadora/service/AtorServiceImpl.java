package com.projetolocadora.service;

import com.projetolocadora.dto.AtorDto;
import com.projetolocadora.entities.Ator;
import com.projetolocadora.repository.AtorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AtorServiceImpl implements AtorService{

    @Autowired
    private AtorRepository atorRepository;

    @Autowired
    private ModelMapper mapper;

    public Page<AtorDto> listarAtores(Pageable paginacao){
        Page<Ator> atores = atorRepository.findAll(paginacao);
        return new PageImpl<>(atores.stream().map(i -> mapper.map(i, AtorDto.class)).toList());
    }

}
