package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.ClienteFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteFilterRepository extends JpaRepository<ClienteFilter, Integer> {
}
