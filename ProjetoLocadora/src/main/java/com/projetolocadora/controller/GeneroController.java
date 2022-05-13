package com.projetolocadora.controller;

import com.projetolocadora.dto.GeneroDto;
import com.projetolocadora.dto.GeneroFilmeDto;
import com.projetolocadora.dto.GeneroFormDto;
import com.projetolocadora.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public Page<GeneroDto> listarGeneros(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return generoService.listarGeneros(paginacao);
    }

    @PostMapping
    public ResponseEntity<GeneroFormDto> inserir(@RequestBody @Valid GeneroFormDto generoFormDto){
        return ResponseEntity.created(generoService.inserir(generoFormDto)).build();
    }

}
