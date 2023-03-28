package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.TipoFatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoFaturaRepository extends JpaRepository<TipoFatura, Integer> {
}
