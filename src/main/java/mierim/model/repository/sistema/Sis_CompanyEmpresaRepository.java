package mierim.model.repository.sistema;


import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface Sis_CompanyEmpresaRepository extends JpaRepository<Sis_CompanyEmpresa, Long> {

}
