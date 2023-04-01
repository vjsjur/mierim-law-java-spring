package mierim.model.repository.juridico;

        import mierim.model.entity.juridico.Jur_AtoGerencialPerfil;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface Jur_AtoGerencialPerfilRepository  extends JpaRepository<Jur_AtoGerencialPerfil, Long> {
}

