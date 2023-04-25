package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.CasoHistorico;
import mierim.model.repository.faturamento.CasoHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/casohistorico/")
public class CasoHistoricoController {

    @Autowired
    private final CasoHistoricoRepository casoHistoricoRepository;

    @GetMapping
    public List<CasoHistorico> listartodos(){
        return casoHistoricoRepository
                .findAll();
    }
    @GetMapping("{id}")
    public CasoHistorico acharPorId(@PathVariable Integer id){
        return casoHistoricoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não Encontrado"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CasoHistorico salvar(@RequestBody @Valid CasoHistorico casoHistorico){
        return casoHistoricoRepository
                .save(casoHistorico);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCaso(@PathVariable Integer id, @RequestBody CasoHistorico casoHistoricoAtualizado){
        casoHistoricoRepository
                .findById(id)
                .map(caso -> {
                    casoHistoricoAtualizado
                            .setId(caso.getId());
                    return casoHistoricoRepository
                            .save(casoHistoricoAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        casoHistoricoRepository
                .findById(id)
                .map(caso -> {
                    casoHistoricoRepository.delete(caso);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Encontrado"));
    }
}
