package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.FatDespesaLancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatDespesaLancamentoRepository extends JpaRepository<FatDespesaLancamento, Integer> {
}
