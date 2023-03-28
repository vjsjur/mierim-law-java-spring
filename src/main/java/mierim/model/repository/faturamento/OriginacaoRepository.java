package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Originacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginacaoRepository extends JpaRepository<Originacao, Integer> {
}
