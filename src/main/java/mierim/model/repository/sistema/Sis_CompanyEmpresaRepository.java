package mierim.model.repository.sistema;


import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface Sis_CompanyEmpresaRepository extends JpaRepository<Sis_CompanyEmpresa, Long> {
    @Query("SELECT obj FROM sis_company_empresa obj WHERE obj.sis_company_group.id_tenant = :idGroup")
    List<Sis_CompanyEmpresa> findAllGroup(@Param(value = "idGroup") Long idGroup);
}
