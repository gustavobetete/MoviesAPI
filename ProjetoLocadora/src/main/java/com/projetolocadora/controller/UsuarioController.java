package com.projetolocadora.controller;

import com.projetolocadora.dto.UsuarioDto;
import com.projetolocadora.dto.UsuarioFormDto;
import com.projetolocadora.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private Page<UsuarioDto> listarUsuarios(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return usuarioService.listarUsuarios(paginacao);
    }

    @PostMapping
    private ResponseEntity<UsuarioFormDto> inserir(@RequestBody @Valid UsuarioFormDto usuarioFormDto){
        return ResponseEntity.created(usuarioService.inserir(usuarioFormDto)).build();
    }
}
