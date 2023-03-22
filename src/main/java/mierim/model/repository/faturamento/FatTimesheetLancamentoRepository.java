package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.FatTimesheetLancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatTimesheetLancamentoRepository extends JpaRepository<FatTimesheetLancamento, Integer> {
}
