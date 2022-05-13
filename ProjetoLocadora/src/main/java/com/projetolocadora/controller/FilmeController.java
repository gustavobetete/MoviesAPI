package com.projetolocadora.controller;

import com.projetolocadora.dto.FilmeDto;
import com.projetolocadora.dto.FilmeFormDto;
import com.projetolocadora.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;
    @GetMapping
    public Page<FilmeDto> listarFilmes(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return filmeService.listarFilmes(paginacao);
    }
    @PostMapping
    public ResponseEntity<FilmeFormDto> inserir(@RequestBody @Valid FilmeFormDto filmeFormDto){
        return ResponseEntity.created(filmeService.inserir(filmeFormDto)).build();
    }
}
