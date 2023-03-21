package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, Integer> {
}
