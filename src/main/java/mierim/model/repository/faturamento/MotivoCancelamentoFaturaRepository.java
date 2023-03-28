package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.MotivoCancelamentoFatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoCancelamentoFaturaRepository extends JpaRepository<MotivoCancelamentoFatura, Integer> {
}
