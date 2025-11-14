package com.gestao_habitos_saudaveis.service;

import com.gestao_habitos_saudaveis.repository.UsuarioRepository;
import com.gestao_habitos_saudaveis.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.salvarUsuario(usuario);
    }
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
    }
}
