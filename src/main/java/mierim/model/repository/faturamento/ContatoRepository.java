package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
