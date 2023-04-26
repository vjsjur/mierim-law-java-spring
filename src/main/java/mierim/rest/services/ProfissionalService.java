package mierim.rest.services;

import mierim.model.entity.faturamento.Profissional;
import mierim.model.repository.faturamento.ProfissionalRepository;
import mierim.rest.dto.ProfissionalDTO;
import mierim.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public Profissional findById(Long id) {
        Optional<Profissional> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Profissional não encontrado! Id: " + id));
    }

    public  Profissional create(ProfissionalDTO objTDO){
        objTDO.setId(null);
        Profissional newObj = new Profissional(objTDO);
        return repository.save(newObj);
    }

}
