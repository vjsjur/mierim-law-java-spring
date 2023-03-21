package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.FatTabeladoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatTabeladoLancamentoRepository extends JpaRepository<FatTabeladoLancamento, Integer> {
}
