package com.projetolocadora.service;

import com.projetolocadora.dto.FilmeDto;
import com.projetolocadora.dto.FilmeFormDto;
import com.projetolocadora.entities.Filme;
import com.projetolocadora.entities.Genero;
import com.projetolocadora.entities.Produtora;
import com.projetolocadora.repository.FilmeRepository;
import com.projetolocadora.repository.GeneroRepository;
import com.projetolocadora.repository.ProdutoraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeServiceImpl implements FilmeService{

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ProdutoraRepository produtoraRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<FilmeDto> listarFilmes(Pageable paginacao) {
        Page<Filme> filmes = filmeRepository.findAll(paginacao);
        return new PageImpl<>(filmes.stream().map(i -> mapper.map(i, FilmeDto.class)).toList());
    }

    @Override
    public URI inserir(FilmeFormDto filmeFormDto) {
        List<Genero> generos = new ArrayList<>();
        Filme filme = mapper.map(filmeFormDto, Filme.class);

        Produtora produtora = produtoraRepository.findByNome(filmeFormDto.getNomeProdutora().getNome()).get();

        for(int i = 0; i < filmeFormDto.getGeneros().size(); i++) {
            Genero genero = generoRepository.findByNome(filmeFormDto.getGeneros().get(i).getNome()).get();
            generos.add(genero);
        }
        System.out.println(generos);
        filme.setGeneros(generos);
        filme.setProdutoras(produtora);
        filmeRepository.save(filme);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId()).toUri();
        return uri;
    }

}
