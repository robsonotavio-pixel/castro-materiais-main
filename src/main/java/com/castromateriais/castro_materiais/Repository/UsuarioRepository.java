package com.castromateriais.castro_materiais.Repository;
import com.castromateriais.castro_materiais.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UsuarioRepository extends JpaRepository <Usuario,Long> {

    Optional<Usuario> findByEmail(String email);
}
