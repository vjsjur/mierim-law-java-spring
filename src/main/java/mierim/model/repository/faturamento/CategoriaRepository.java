package mierim.model.repository.faturamento;

import mierim.model.entity.faturamento.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
