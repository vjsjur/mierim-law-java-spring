package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
