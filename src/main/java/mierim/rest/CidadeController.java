package mierim.rest;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.autocontida.Cidade;
import mierim.model.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {

    @Autowired
    private final CidadeRepository cidadeRepository;

    @GetMapping
    public List<Cidade> listarTodos(){
        return cidadeRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Cidade acharPorId(@PathVariable Integer id){
        return cidadeRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cidade não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade salvar(@RequestBody @Valid Cidade cidade){
        return cidadeRepository
                .save(cidade);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCidade(@PathVariable Integer id, @RequestBody Cidade cidadeAtualizado) {
        cidadeRepository
                .findById(id)
                .map(cidade -> {
                    cidadeAtualizado
                            .setId(cidade.getId());
        return cidadeRepository
                .save(cidadeAtualizado);
        })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cidade não Encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        cidadeRepository
                .findById(id)
                .map(cidade -> {
                    cidadeRepository.delete(cidade);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não Encontrada"));
    }

}
