package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.CasoExcecaoProfissional;
import mierim.model.repository.faturamento.CasoExcecaoProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/casoexcecaoprofissional/")
public class CasoExcecaoProfissionalController {

    @Autowired
    private final CasoExcecaoProfissionalRepository casoExcecaoProfissionalRepository;

    @GetMapping
    public List<CasoExcecaoProfissional> listartodos(){
        return casoExcecaoProfissionalRepository
                .findAll();
    }
    @GetMapping("{id}")
    public CasoExcecaoProfissional acharPorId(@PathVariable Integer id){
        return casoExcecaoProfissionalRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não Encontrado"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CasoExcecaoProfissional salvat(@RequestBody @Valid CasoExcecaoProfissional casoExcecaoProfissional){
        return casoExcecaoProfissionalRepository
                .save(casoExcecaoProfissional);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCaso(@PathVariable Integer id, @RequestBody CasoExcecaoProfissional casoExcecaoProfissionalAtualizado){
        casoExcecaoProfissionalRepository
                .findById(id)
                .map(caso -> {
                    casoExcecaoProfissionalAtualizado
                            .setId(caso.getId());
                    return casoExcecaoProfissionalRepository
                            .save(casoExcecaoProfissionalAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        casoExcecaoProfissionalRepository
                .findById(id)
                .map(caso -> {
                    casoExcecaoProfissionalRepository.delete(caso);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Encontrado"));
    }
}
