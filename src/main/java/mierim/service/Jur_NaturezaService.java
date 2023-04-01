package mierim.service;

import mierim.model.entity.juridico.Jur_Natureza;
import mierim.model.repository.juridico.Jur_NaturezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Jur_NaturezaService {

    @Autowired
    private Jur_NaturezaRepository jurNaturezaRepository;

    public List<Jur_Natureza> listarTodos(){
        return jurNaturezaRepository
                .findAll();
    }

       public Jur_Natureza acharPorId(Long id) {
        return jurNaturezaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Natureza não Encontrada"));
    }
}
