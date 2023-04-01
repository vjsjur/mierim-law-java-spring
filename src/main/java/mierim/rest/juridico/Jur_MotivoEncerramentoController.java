package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_MotivoEncerramento;
import mierim.model.entity.juridico.Jur_Objeto;
import mierim.model.repository.juridico.Jur_MotivoEncerramentoRepository;
import mierim.model.repository.juridico.Jur_ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_motivo_encerramento")
@RequiredArgsConstructor
public class Jur_MotivoEncerramentoController{

    @Autowired
    private final Jur_MotivoEncerramentoRepository jur_MotivoEncerramentoRepository;

    @GetMapping
    public List<Jur_MotivoEncerramento> listarTodos(){
        return jur_MotivoEncerramentoRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_MotivoEncerramento acharPorId(@PathVariable Long id){
        return jur_MotivoEncerramentoRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Motivo de Encerramento não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_MotivoEncerramento salvar(@RequestBody @Valid Jur_MotivoEncerramento jur_MotivoEncerramento){
        return jur_MotivoEncerramentoRepository
                .save(jur_MotivoEncerramento);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_MotivoEncerramento(@PathVariable Long id, @RequestBody Jur_MotivoEncerramento jur_MotivoEncerramentoAtualizado) {
        jur_MotivoEncerramentoRepository
                .findById(id)
                .map(jur_motivoEncerramento -> {
                    jur_MotivoEncerramentoAtualizado
                            .setId(jur_motivoEncerramento.getId());
                    return jur_MotivoEncerramentoRepository
                            .save(jur_MotivoEncerramentoAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_MotivoEncerramentoRepository
                .findById(id)
                .map(jur_motivoEncerramento -> {
                    jur_MotivoEncerramentoRepository.delete(jur_motivoEncerramento);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motivo de Encerramento não Encontrado"));
    }

}
