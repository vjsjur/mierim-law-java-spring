package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.AtividadeTimesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeTimesheetRepository  extends JpaRepository<AtividadeTimesheet, Integer> {
}
