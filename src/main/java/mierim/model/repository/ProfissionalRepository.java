package mierim.model.repository;

import mierim.model.entity.faturamento.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository  extends JpaRepository<Profissional, Long> {
}
