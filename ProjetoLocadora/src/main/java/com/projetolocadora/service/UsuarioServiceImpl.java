package com.projetolocadora.service;

import com.projetolocadora.dto.UsuarioDto;
import com.projetolocadora.entities.Usuario;
import com.projetolocadora.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<UsuarioDto> listarUsuarios(Pageable paginacao){
        Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
        return new PageImpl<>(usuarios.stream().map(i-> mapper.map(i, UsuarioDto.class)).toList());
    }
}
