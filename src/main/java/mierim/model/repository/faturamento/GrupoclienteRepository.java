package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Grupocliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoclienteRepository extends JpaRepository<Grupocliente, Integer> {
}
