package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.CasoExcecaoCategoria;
import mierim.model.repository.faturamento.CasoExcecaoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/casoexcecaocategoria/")
public class CasoExcecaoCategoriaController {

    @Autowired
    private final CasoExcecaoCategoriaRepository casoExcecaoCategoriaRepository;

    @GetMapping
    public List<CasoExcecaoCategoria> listartodos(){
        return casoExcecaoCategoriaRepository
                .findAll();
    }
    @GetMapping("{id}")
    public CasoExcecaoCategoria acharPorId(@PathVariable Integer id){
        return casoExcecaoCategoriaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não Encontrado"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CasoExcecaoCategoria salvat(@RequestBody @Valid CasoExcecaoCategoria casoExcecaoCategoria){
        return casoExcecaoCategoriaRepository
                .save(casoExcecaoCategoria);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCaso(@PathVariable Integer id, @RequestBody CasoExcecaoCategoria casoExcecaoCategoriaAtualizado){
        casoExcecaoCategoriaRepository
                .findById(id)
                .map(caso -> {
                    casoExcecaoCategoriaAtualizado
                            .setId(caso.getId());
                    return casoExcecaoCategoriaRepository
                            .save(casoExcecaoCategoriaAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        casoExcecaoCategoriaRepository
                .findById(id)
                .map(caso -> {
                    casoExcecaoCategoriaRepository.delete(caso);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Encontrado"));
    }
}
