package mierim.rest.juridico;

        import lombok.RequiredArgsConstructor;
        import mierim.model.entity.juridico.Jur_TipoResponsabilidade;
        import mierim.model.repository.juridico.Jur_TipoResponsabilidadeRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.server.ResponseStatusException;

        import javax.validation.Valid;
        import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_tiporesponsabilidade/")
@RequiredArgsConstructor
public class Jur_TipoResponsabilidadeController {

        @Autowired
    private final Jur_TipoResponsabilidadeRepository jur_TipoResponsabilidadelRepository;

    @GetMapping
    public List<Jur_TipoResponsabilidade> listarTodos(){
        return jur_TipoResponsabilidadelRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_TipoResponsabilidade acharPorId(@PathVariable Long id){
        return jur_TipoResponsabilidadelRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Responsabilidade não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_TipoResponsabilidade salvar(@RequestBody @Valid Jur_TipoResponsabilidade jur_TipoResponsabilidade){
        return jur_TipoResponsabilidadelRepository
                .save(jur_TipoResponsabilidade);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_TipoResponsabilidade(@PathVariable Long id, @RequestBody Jur_TipoResponsabilidade jur_TipoResponsabilidadeAtualizado) {
        jur_TipoResponsabilidadelRepository
                .findById(id)
                .map(jur_TipoValor -> {
                    jur_TipoResponsabilidadeAtualizado
                            .setId(jur_TipoValor.getId());
                    return jur_TipoResponsabilidadelRepository
                            .save(jur_TipoResponsabilidadeAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Valor não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_TipoResponsabilidadelRepository
                .findById(id)
                .map(jur_TipoResponsabilidadel -> {
                    jur_TipoResponsabilidadelRepository.delete(jur_TipoResponsabilidadel);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Responsabilidade não Encontrada"));
    }

}
