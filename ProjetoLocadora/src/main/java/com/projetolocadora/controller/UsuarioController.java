package com.projetolocadora.controller;

import com.projetolocadora.dto.UsuarioDto;
import com.projetolocadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private Page<UsuarioDto> listarUsuarios(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return usuarioService.listarUsuarios(paginacao);
    }
}
