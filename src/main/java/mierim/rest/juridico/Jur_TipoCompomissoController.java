package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_TipoCompromisso;
import mierim.model.repository.juridico.Jur_TipoCompromissoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_tipocompromisso/")
@RequiredArgsConstructor
public class Jur_TipoCompomissoController{

    @Autowired
    private final Jur_TipoCompromissoRepository jur_TipoCompromissolRepository;

    @GetMapping
    public List<Jur_TipoCompromisso> listarTodos(){
        return jur_TipoCompromissolRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_TipoCompromisso acharPorId(@PathVariable Long id){
        return jur_TipoCompromissolRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Compromisso não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_TipoCompromisso salvar(@RequestBody @Valid Jur_TipoCompromisso jur_TipoCompromisso){
        return jur_TipoCompromissolRepository
                .save(jur_TipoCompromisso);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_TipoCompromisso(@PathVariable Long id, @RequestBody Jur_TipoCompromisso jur_TipoCompromissoAtualizado) {
        jur_TipoCompromissolRepository
                .findById(id)
                .map(jur_TipoValor -> {
                    jur_TipoCompromissoAtualizado
                            .setId(jur_TipoValor.getId());
                    return jur_TipoCompromissolRepository
                            .save(jur_TipoCompromissoAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Valor não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_TipoCompromissolRepository
                .findById(id)
                .map(jur_TipoCompromissol -> {
                    jur_TipoCompromissolRepository.delete(jur_TipoCompromissol);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Compromisso não Encontrada"));
    }

}
