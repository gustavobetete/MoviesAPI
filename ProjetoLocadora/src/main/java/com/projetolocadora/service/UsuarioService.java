package com.projetolocadora.service;

import com.projetolocadora.dto.UsuarioDto;
import com.projetolocadora.dto.UsuarioFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface UsuarioService {
    Page<UsuarioDto> listarUsuarios(Pageable paginacao);

    URI inserir(UsuarioFormDto usuarioFormDto);
}
