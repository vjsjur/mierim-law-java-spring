package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.Profissional;
import mierim.model.entity.juridico.Jur_TipoValor;
import mierim.model.repository.faturamento.ProfissionalRepository;
import mierim.model.repository.juridico.Jur_TipoValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_tipovalor")
@RequiredArgsConstructor
public class Jur_TipoValorController {

    @Autowired
    private final Jur_TipoValorRepository jur_TipoValorlRepository;

    @GetMapping
    public List<Jur_TipoValor> listarTodos(){
        return jur_TipoValorlRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_TipoValor acharPorId(@PathVariable Long id){
        return jur_TipoValorlRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Valor não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_TipoValor salvar(@RequestBody @Valid Jur_TipoValor jur_TipoValor){
        return jur_TipoValorlRepository
                .save(jur_TipoValor);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_TipoValor(@PathVariable Long id, @RequestBody Jur_TipoValor jur_TipoValorAtualizado) {
        jur_TipoValorlRepository
                .findById(id)
                .map(jur_tipo_responsabilidade -> {
                    jur_TipoValorAtualizado
                            .setId(jur_tipo_responsabilidade.getId());
                    return jur_TipoValorlRepository
                            .save(jur_TipoValorAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Valor não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_TipoValorlRepository
                .findById(id)
                .map(jur_TipoValor -> {
                    jur_TipoValorlRepository.delete(jur_TipoValor);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Valor não Encontrado"));
    }

}
