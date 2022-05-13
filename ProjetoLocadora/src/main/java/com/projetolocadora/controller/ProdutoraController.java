package com.projetolocadora.controller;

import com.projetolocadora.dto.ProdutoraDto;
import com.projetolocadora.entities.Produtora;
import com.projetolocadora.service.ProdutoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtoras")
public class ProdutoraController {

    @Autowired
    private ProdutoraService produtoraService;

    @GetMapping
    private Page<ProdutoraDto> listarProdutoras(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return produtoraService.listarProdutoras(paginacao);
    }
}
