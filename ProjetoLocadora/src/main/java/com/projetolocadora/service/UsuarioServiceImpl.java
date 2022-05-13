package com.projetolocadora.service;

import com.projetolocadora.dto.UsuarioDto;
import com.projetolocadora.dto.UsuarioFormDto;
import com.projetolocadora.entities.Usuario;
import com.projetolocadora.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @Override
    public URI inserir(UsuarioFormDto usuarioFormDto) {
        Usuario usuario = mapper.map(usuarioFormDto, Usuario.class);
        usuarioRepository.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return uri;
    }
}
