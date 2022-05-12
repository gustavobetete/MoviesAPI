package com.projetolocadora.controller;

import com.projetolocadora.dto.FilmeDto;
import com.projetolocadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;
    @GetMapping
    public Page<FilmeDto> listarFilmes(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return filmeService.listarFilmes(paginacao);
    }
}
