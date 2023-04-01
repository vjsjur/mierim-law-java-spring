package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_Natureza;
import mierim.model.repository.juridico.Jur_NaturezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_natureza")
@RequiredArgsConstructor
public class Jur_NaturezaController{

    @Autowired
    private final Jur_NaturezaRepository jur_NaturezaRepository;

    @GetMapping
    public List<Jur_Natureza> listarTodos(){
        return jur_NaturezaRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_Natureza acharPorId(@PathVariable Long id){
        return jur_NaturezaRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Natureza não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_Natureza salvar(@RequestBody @Valid Jur_Natureza jur_Natureza){
        return jur_NaturezaRepository
                .save(jur_Natureza);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_Natureza(@PathVariable Long id, @RequestBody Jur_Natureza jur_NaturezaAtualizado) {
        jur_NaturezaRepository
                .findById(id)
                .map(jur_Objeto -> {
                    jur_NaturezaAtualizado
                            .setId(jur_Objeto.getId());
                    return jur_NaturezaRepository
                            .save(jur_NaturezaAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Natureza não Encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_NaturezaRepository
                .findById(id)
                .map(jur_natureza -> {
                    jur_NaturezaRepository.delete(jur_natureza);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Natureza não Encontrada"));
    }

}
