package mierim.rest.services;


import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyEmpresaRepository;
import mierim.model.repository.sistema.Sis_CompanyGroupRepository;
import mierim.rest.dto.Sis_CompanyEmpresaDTO;
import mierim.rest.dto.Sis_CompanyGroupDTO;
import mierim.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Sis_CompanyGroupService {

    @Autowired
    private Sis_CompanyGroupRepository sisCompanyGroupRepository;

    public Sis_CompanyGroup findById(Long id) {
        Optional<Sis_CompanyGroup> obj = sisCompanyGroupRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public  Sis_CompanyGroup create(Sis_CompanyGroupDTO objTDO){
        objTDO.setId_tenant(null);
        Sis_CompanyGroup newObj = new Sis_CompanyGroup(objTDO);
        return sisCompanyGroupRepository.save(newObj);
    }

}
