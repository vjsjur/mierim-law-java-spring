package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.CasoParticipacao;
import mierim.model.repository.faturamento.CasoParticipacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/casoparticipacao/")
public class CasoParticipacaoController {

    @Autowired
    private final CasoParticipacaoRepository casoParticipacaoRepository;

    @GetMapping
    public List<CasoParticipacao> listartodos(){
        return casoParticipacaoRepository
                .findAll();
    }
    @GetMapping("{id}")
    public CasoParticipacao acharPorId(@PathVariable Integer id){
        return casoParticipacaoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não Encontrado"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CasoParticipacao salvar(@RequestBody @Valid CasoParticipacao casoParticipacao){
        return casoParticipacaoRepository
                .save(casoParticipacao);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCaso(@PathVariable Integer id, @RequestBody CasoParticipacao casoParticipacaoAtualizado){
        casoParticipacaoRepository
                .findById(id)
                .map(caso -> {
                    casoParticipacaoAtualizado
                            .setId(caso.getId());
                    return casoParticipacaoRepository
                            .save(casoParticipacaoAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        casoParticipacaoRepository
                .findById(id)
                .map(caso -> {
                    casoParticipacaoRepository.delete(caso);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não Encontrado"));
    }
}
