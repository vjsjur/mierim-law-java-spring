package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_AreaJuridica;
import mierim.model.repository.juridico.Jur_AreaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_area_juridica")
@RequiredArgsConstructor
public class Jur_AreaJuridicaController{

    @Autowired
    private final Jur_AreaJuridicaRepository areaJuridicaRepository;

    @GetMapping("/listar_todos")
    public List<Jur_AreaJuridica> listarTodos(){
        return areaJuridicaRepository.findAll();
    }

    @GetMapping("/listar_por_contem")
    public List<Jur_AreaJuridica> listarPorNome(String nome){
        return areaJuridicaRepository.findByDescricaoContainingIgnoreCase(nome);
    }

    @GetMapping("{id}")
    public Jur_AreaJuridica acharPorId(@PathVariable Long id){
        return areaJuridicaRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_AreaJuridica salvar(@RequestBody @Valid Jur_AreaJuridica jur_areajuridica){
        return areaJuridicaRepository
                .save(jur_areajuridica);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaAreaJuridica(@PathVariable Long id, @RequestBody Jur_AreaJuridica jurAreaJuridicaAtualizada) {
        areaJuridicaRepository
                .findById(id)
                .map(jur_Objeto -> {
                    jurAreaJuridicaAtualizada
                            .setId(jur_Objeto.getId());
                    return areaJuridicaRepository
                            .save(jurAreaJuridicaAtualizada);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        areaJuridicaRepository
                .findById(id)
                .map(jur_areajuridica -> {
                    areaJuridicaRepository.delete(jur_areajuridica);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não Encontrado"));
    }

}
