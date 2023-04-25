package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.Profissional;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.repository.faturamento.ProfissionalRepository;
import mierim.rest.dto.ProfissionalDTO;
import mierim.rest.dto.Sis_CompanyEmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/profissional/")
@RequiredArgsConstructor
public class ProfissionalController {

    @Autowired
    private final ProfissionalRepository profissionalRepository;



    @GetMapping("listar_todos/")
    public List<Profissional> listarTodos(){
        return profissionalRepository
                .findAll();
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> findAllTodos(){
        List<Profissional> list = profissionalRepository.findAll();
        List<ProfissionalDTO> listDTO = list.stream().map(obj -> new ProfissionalDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("{id}")
    public Profissional acharPorId(@PathVariable Long id){
        return profissionalRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Profissional não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional salvar(@RequestBody @Valid Profissional profissional){
        return profissionalRepository
                .save(profissional);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosProfissional(@PathVariable Long id, @RequestBody Profissional profissionalAtualizado) {
        profissionalRepository
                .findById(id)
                .map(profissional -> {
                    profissionalAtualizado
                            .setId(profissional.getId());
                    return profissionalRepository
                            .save(profissionalAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Profissional não Encontrada"));
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        profissionalRepository
                .findById(id)
                .map(profissional -> {
                    profissionalRepository.delete(profissional);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não Encontrada"));
    }

}
