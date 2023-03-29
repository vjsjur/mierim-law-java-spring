package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_TipoEnvolvimento;
import mierim.model.repository.juridico.Jur_TipoEnvolvimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_tipoenvolvimento")
@RequiredArgsConstructor
public class Jur_TipoEnvolvimentoController{

    @Autowired
    private final Jur_TipoEnvolvimentoRepository jur_TipoEnvolvimentolRepository;

    @GetMapping
    public List<Jur_TipoEnvolvimento> listarTodos(){
        return jur_TipoEnvolvimentolRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_TipoEnvolvimento acharPorId(@PathVariable Long id){
        return jur_TipoEnvolvimentolRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Envolvimento não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_TipoEnvolvimento salvar(@RequestBody @Valid Jur_TipoEnvolvimento jur_TipoEnvolvimento){
        return jur_TipoEnvolvimentolRepository
                .save(jur_TipoEnvolvimento);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_TipoEnvolvimento(@PathVariable Long id, @RequestBody Jur_TipoEnvolvimento jur_TipoEnvolvimentoAtualizado) {
        jur_TipoEnvolvimentolRepository
                .findById(id)
                .map(jur_TipoValor -> {
                    jur_TipoEnvolvimentoAtualizado
                            .setId(jur_TipoValor.getId());
                    return jur_TipoEnvolvimentolRepository
                            .save(jur_TipoEnvolvimentoAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Valor não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_TipoEnvolvimentolRepository
                .findById(id)
                .map(jur_TipoEnvolvimentol -> {
                    jur_TipoEnvolvimentolRepository.delete(jur_TipoEnvolvimentol);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Envolvimento não Encontrada"));
    }

}
