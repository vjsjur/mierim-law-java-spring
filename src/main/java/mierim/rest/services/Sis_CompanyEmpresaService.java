package mierim.rest.services;

import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyEmpresaRepository;
import mierim.rest.dto.Sis_CompanyEmpresaDTO;
import mierim.rest.dto.Sis_CompanyGroupDTO;
import mierim.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Sis_CompanyEmpresaService {
    @Autowired
    private  Sis_CompanyGroupService groupService;

    @Autowired
    private Sis_CompanyEmpresaRepository sisCompanyEmpresaRepository;

    public Sis_CompanyEmpresa findById(Long id) {
        Optional<Sis_CompanyEmpresa> obj = sisCompanyEmpresaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public  Sis_CompanyEmpresa create(Sis_CompanyEmpresaDTO objTDO){
        objTDO.setId_tenant_company(null);
        Sis_CompanyEmpresa newObj = new Sis_CompanyEmpresa(objTDO);
        return sisCompanyEmpresaRepository.save(newObj);
    }

}
