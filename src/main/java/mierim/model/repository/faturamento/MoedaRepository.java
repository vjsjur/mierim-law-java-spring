package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoedaRepository extends JpaRepository<Moeda, Integer> {
}
