package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
