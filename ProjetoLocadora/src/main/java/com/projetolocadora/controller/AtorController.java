package com.projetolocadora.controller;

import com.projetolocadora.dto.AtorDto;
import com.projetolocadora.dto.AtorFormDto;
import com.projetolocadora.service.AtorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atores")
public class AtorController{

    @Autowired
    AtorService atorService;

    @GetMapping
    public ResponseEntity<Page<AtorDto>> listarAtores(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return ResponseEntity.ok().body(atorService.listarAtores(paginacao));
    }

    @PostMapping
    public ResponseEntity<AtorFormDto> inserir(@RequestBody @Valid AtorFormDto atorFormDto){
        return ResponseEntity.created(atorService.inserir(atorFormDto)).build();
    }



}
