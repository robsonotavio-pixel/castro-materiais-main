package com.castromateriais.castro_materiais.service;
import com.castromateriais.castro_materiais.model.Usuario;
import com.castromateriais.castro_materiais.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

   public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id ) {
        return usuarioRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("usuario não encontrado com id " + id));
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        return usuarioRepository.save(usuario);
    }
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("email ou senha inválidos"));
        if (!usuario.getSenha().equals(senha)) {
            throw new RuntimeException("email ou senha inválidos");
        }
        return usuario;
    }
}
