package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.Caso;
import mierim.model.entity.faturamento.Categoria;
import mierim.model.repository.faturamento.CasoRepository;
import mierim.model.repository.faturamento.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private final CategoriaRepository CategoriaRepository;

    @GetMapping
    public List<Categoria> listartodos(){
        return CategoriaRepository
                .findAll();
    }
    @GetMapping("{id}")
    public Categoria acharPorId(@PathVariable Integer id){
        return CategoriaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não Encontrado"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvat(@RequestBody @Valid Categoria categoria){
        return CategoriaRepository
                .save(categoria);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCategoria(@PathVariable Integer id, @RequestBody Categoria categoriaAtualizado){
        CategoriaRepository
                .findById(id)
                .map(caso -> {
                    categoriaAtualizado
                            .setId(caso.getId());
                    return CategoriaRepository
                            .save(categoriaAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        CategoriaRepository
                .findById(id)
                .map(categoria -> {
                    CategoriaRepository.delete(categoria);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Encontrado"));
    }
}
