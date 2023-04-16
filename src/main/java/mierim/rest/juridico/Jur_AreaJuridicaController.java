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
    private final Jur_AreaJuridicaRepository jur_areaJuridicaRepository;

    @GetMapping
    public List<Jur_AreaJuridica> listarTodos(){
        return jur_areaJuridicaRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_AreaJuridica acharPorId(@PathVariable Long id){
        return jur_areaJuridicaRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_AreaJuridica salvar(@RequestBody @Valid Jur_AreaJuridica jur_areajuridica){
        return jur_areaJuridicaRepository
                .save(jur_areajuridica);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaAreaJuridica(@PathVariable Long id, @RequestBody Jur_AreaJuridica jurAreaJuridicaAtualizada) {
        jur_areaJuridicaRepository
                .findById(id)
                .map(jur_Objeto -> {
                    jurAreaJuridicaAtualizada
                            .setId(jur_Objeto.getId());
                    return jur_areaJuridicaRepository
                            .save(jurAreaJuridicaAtualizada);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Objeto não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_areaJuridicaRepository
                .findById(id)
                .map(jur_areajuridica -> {
                    jur_areaJuridicaRepository.delete(jur_areajuridica);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não Encontrado"));
    }

}
