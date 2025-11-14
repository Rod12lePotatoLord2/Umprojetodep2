package com.gestao_habitos_saudaveis.service;

import com.gestao_habitos_saudaveis.exception.DadosInvalidosException;
import com.gestao_habitos_saudaveis.exception.RecursoNaoEncontradoException;
import com.gestao_habitos_saudaveis.model.Usuario;
import com.gestao_habitos_saudaveis.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario salvarUsuario(Usuario usuario){
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new DadosInvalidosException("Email não pode ser vazio");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 3) {
            throw new DadosInvalidosException("Senha muito curta");
        }

        return usuarioRepository.salvarUsuario(usuario);
    }
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
    }
    public Usuario buscarPorEmail(String email){
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Usuário com email " + email + " não encontrado");
        }
        return usuario;
    }
    public Usuario atualizarUsuario(Usuario usuarioAtualizado){
        if (usuarioAtualizado.getEmail() == null || usuarioAtualizado.getEmail().isEmpty()) {
            throw new DadosInvalidosException("Email não pode ser vazio");
        }
        boolean atualizado = usuarioRepository.atualizarUsuario(usuarioAtualizado);
        if (!atualizado) {
            throw new RecursoNaoEncontradoException(
                    "Usuário com email " + usuarioAtualizado.getEmail() + " não encontrado para atualização"
            );
        }
        return usuarioAtualizado;
    }

    public void excluirUsuario(String email){
        boolean excluido = usuarioRepository.excluirUsuario(email);
        if (!excluido) {
            throw new RecursoNaoEncontradoException(
                    "Usuário com email " + email + " não encontrado para exclusão"
            );
        }
    }
}
