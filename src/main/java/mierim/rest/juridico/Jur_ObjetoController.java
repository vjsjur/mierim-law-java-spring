package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_Objeto;
import mierim.model.repository.juridico.Jur_ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_objeto")
@RequiredArgsConstructor
public class Jur_ObjetoController{

    @Autowired
    private final Jur_ObjetoRepository jur_ObjetolRepository;

    @GetMapping
    public List<Jur_Objeto> listarTodos(){
        return jur_ObjetolRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_Objeto acharPorId(@PathVariable Long id){
        return jur_ObjetolRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_Objeto salvar(@RequestBody @Valid Jur_Objeto jur_Objeto){
        return jur_ObjetolRepository
                .save(jur_Objeto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_Objeto(@PathVariable Long id, @RequestBody Jur_Objeto jur_ObjetoAtualizado) {
        jur_ObjetolRepository
                .findById(id)
                .map(jur_Objeto -> {
                    jur_ObjetoAtualizado
                            .setId(jur_Objeto.getId());
                    return jur_ObjetolRepository
                            .save(jur_ObjetoAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_ObjetolRepository
                .findById(id)
                .map(jur_objeto -> {
                    jur_ObjetolRepository.delete(jur_objeto);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não Encontrado"));
    }

}
