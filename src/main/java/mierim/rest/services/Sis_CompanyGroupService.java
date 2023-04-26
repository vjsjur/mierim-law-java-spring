package mierim.rest.services;


import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyGroupRepository;
import mierim.rest.dto.sistema.Sis_CompanyGroupDTO;
import mierim.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Sis_CompanyGroupService {

    @Autowired
    private Sis_CompanyGroupRepository repository;


    //Lista Todos
    public List<Sis_CompanyGroup> findAll() {
        return repository.findAll();
    }

    //Busca Por Id
    public Sis_CompanyGroup findById(Long id) {
        Optional<Sis_CompanyGroup> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }


    //Insere
    public  Sis_CompanyGroup create(Sis_CompanyGroup obj){
        obj.setId_tenant(null);
        return repository.save(obj);
    }

    //Atualiza
    public Sis_CompanyGroup update(Long id, Sis_CompanyGroupDTO objDTO) {
        Sis_CompanyGroup obj = findById(id);
        obj.setGrupo_economico(objDTO.getGrupo_economico());
        obj.setNome(objDTO.getNome());
        obj.setData_alteracao(new Date());
        obj.setDominio(objDTO.getDominio());
        obj.setStatus(objDTO.getStatus());
        return repository.save(obj);
    }

    //Deleta
    public Sis_CompanyGroup delete(Long id, Sis_CompanyGroupDTO objDTO) {
        Sis_CompanyGroup obj = findById(id);
        obj.setDeletado("S");
        return repository.save(obj);
    }
}
