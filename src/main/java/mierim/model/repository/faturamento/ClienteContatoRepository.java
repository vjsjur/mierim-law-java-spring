package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.ClienteContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteContatoRepository extends JpaRepository<ClienteContato, Integer> {
}
