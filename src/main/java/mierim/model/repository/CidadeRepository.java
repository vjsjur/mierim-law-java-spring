package mierim.model.repository;


import mierim.model.entity.Cidade;
import mierim.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
