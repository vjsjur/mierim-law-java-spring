package mierim.rest.services;

import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyEmpresaRepository;
import mierim.rest.dto.sistema.Sis_CompanyEmpresaDTO;
import mierim.rest.dto.sistema.Sis_CompanyGroupDTO;
import mierim.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Sis_CompanyEmpresaService {
    @Autowired
    private Sis_CompanyEmpresaRepository repository;

    @Autowired
    private Sis_CompanyGroupService groupService;

    public List<Sis_CompanyEmpresa> findAll() {
        return repository.findAll();
    }

    public Sis_CompanyEmpresa findById(Long id) {
        Optional<Sis_CompanyEmpresa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Sis_CompanyEmpresa.class.getName()));
    }

    //Insere
    public  Sis_CompanyEmpresa create(Sis_CompanyEmpresa obj){
        obj.setId_tenant_company(null);
        return repository.save(obj);
    }


    //Atualiza
    public Sis_CompanyEmpresa update(Long id, Sis_CompanyEmpresaDTO objDTO) {
        Sis_CompanyEmpresa obj = findById(id);

        obj.setNome_emp(objDTO.getNome_emp());
        obj.setNome_fant(objDTO.getNome_fant());
        obj.setLogradouro(objDTO.getLogradouro());
        obj.setCep(objDTO.getCep());
        obj.setComplemento(objDTO.getComplemento());
        obj.setBairro(objDTO.getBairro());
       //obj.setMunicipio(objDTO.getId_municipio());
        obj.setEmail(objDTO.getEmail());
        obj.setCpf_cnpj(objDTO.getCpf_cnpj());
        obj.setData_alteracao(new Date());
        obj.setStatus(objDTO.getStatus());
       // obj.setSis_company_group(objDTO.getId_tenant());

        return repository.save(obj);
    }

    //Deleta
    public Sis_CompanyEmpresa delete(Long id, Sis_CompanyEmpresaDTO objDTO) {
        Sis_CompanyEmpresa obj = findById(id);
        obj.setDeletado("S");
        return repository.save(obj);
    }

    public List<Sis_CompanyEmpresa> findAllGroup(Long idGroup) {
         groupService.findById(idGroup);
         return repository.findAllGroup(idGroup);
    }
}
