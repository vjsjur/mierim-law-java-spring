package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_Processo;
import mierim.model.entity.juridico.Jur_TipoEnvolvimento;
import mierim.model.repository.juridico.Jur_ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_processo")
@RequiredArgsConstructor
public class Jur_ProcessoController{

    @Autowired
    private final Jur_ProcessoRepository jur_ProcessoRepository;

    @GetMapping
    public List<Jur_Processo> listarTodos(){
        return jur_ProcessoRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_Processo acharPorId(@PathVariable Long id){
        return jur_ProcessoRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Processo não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_Processo salvar(@RequestBody @Valid Jur_Processo jur_Processo){
        return jur_ProcessoRepository
                .save(jur_Processo);
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_ProcessoRepository
                .findById(id)
                .map(jur_Processo -> {
                    jur_ProcessoRepository.delete(jur_Processo);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Processo não Encontrado"));
    }



}
