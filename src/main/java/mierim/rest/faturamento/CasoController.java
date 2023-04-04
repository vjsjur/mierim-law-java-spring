package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.Caso;
import mierim.model.repository.faturamento.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/caso/")
public class CasoController {

    @Autowired
    private final CasoRepository casoRepository;

    @GetMapping
    public List<Caso> listartodos(){
        return casoRepository
                .findAll();
    }
    @GetMapping("{id}")
    public Caso acharPorId(@PathVariable Integer id){
        return casoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não Encontrado"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caso salvat(@RequestBody @Valid Caso caso){
        return casoRepository
                .save(caso);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCaso(@PathVariable Integer id, @RequestBody Caso casoAtualizado){
        casoRepository
                .findById(id)
                .map(caso -> {
                    casoAtualizado
                            .setId(caso.getId());
                    return casoRepository
                            .save(casoAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        casoRepository
                .findById(id)
                .map(caso -> {
                    casoRepository.delete(caso);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Encontrado"));
    }
}
