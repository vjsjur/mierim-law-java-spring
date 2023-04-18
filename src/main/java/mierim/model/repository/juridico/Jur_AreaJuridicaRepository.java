package mierim.model.repository.juridico;

import mierim.model.entity.juridico.Jur_AreaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Jur_AreaJuridicaRepository  extends JpaRepository<Jur_AreaJuridica, Long> {

      public List<Jur_AreaJuridica> findByDescricaoContaining(String nome);

}
