package com.projetolocadora.service;

import com.projetolocadora.dto.ProdutoraDto;
import com.projetolocadora.dto.ProdutoraFormDto;
import com.projetolocadora.entities.Produtora;
import com.projetolocadora.repository.ProdutoraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class ProdutoraServiceImpl implements ProdutoraService {

    @Autowired
    private ProdutoraRepository produtoraRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<ProdutoraDto> listarProdutoras(Pageable paginacao){
        Page<Produtora> produtoras = produtoraRepository.findAll(paginacao);
        return new PageImpl<>(produtoras.stream().map(i-> mapper.map(i, ProdutoraDto.class)).toList());
    }

    @Override
    public URI inserir(ProdutoraFormDto produtoraFormDto) {
        Produtora produtora = mapper.map(produtoraFormDto, Produtora.class);
        produtoraRepository.save(produtora);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtora.getId()).toUri();
        return uri;
    }
}
