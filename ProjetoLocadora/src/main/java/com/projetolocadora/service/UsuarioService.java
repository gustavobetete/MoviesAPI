package com.projetolocadora.service;

import com.projetolocadora.dto.UsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    Page<UsuarioDto> listarUsuarios(Pageable paginacao);
}
