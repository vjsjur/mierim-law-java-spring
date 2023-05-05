package mierim.model.repository.sistema;


import mierim.model.entity.sistema.Sis_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Sis_UsuarioRepository extends JpaRepository<Sis_Usuario, Integer> {

    Optional<Sis_Usuario> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}

