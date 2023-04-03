package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.AtividadeTimesheet;
import mierim.model.entity.faturamento.AtividadeTimesheetIdioma;
import mierim.model.repository.faturamento.AtividadeTimesheetIdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/AtividadeTimesheetIdioma/")
@RequiredArgsConstructor
public class AtividadeTimesheetIdiomaController {

    @Autowired
    private final AtividadeTimesheetIdiomaRepository atividadeTimesheetIdiomaRepository;

    @GetMapping
    public List<AtividadeTimesheetIdioma> listarTodos() {
        return atividadeTimesheetIdiomaRepository
                .findAll();
    }

    @GetMapping("{id}")
    public AtividadeTimesheetIdioma acharPorId(@PathVariable Integer id){
        return atividadeTimesheetIdiomaRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atividade TimeSheet Idiomas não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtividadeTimesheetIdioma salvar(@RequestBody @Valid AtividadeTimesheetIdioma atividadeTimesheetIdioma){
        return atividadeTimesheetIdiomaRepository
                .save(atividadeTimesheetIdioma);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCliente(@PathVariable Integer id, @RequestBody AtividadeTimesheetIdioma atividadeTimesheetIdiomaAtualizado) {
        atividadeTimesheetIdiomaRepository
                .findById(id)
                .map(cliente -> {
                    atividadeTimesheetIdiomaAtualizado
                            .setId(cliente.getId());
                    return atividadeTimesheetIdiomaRepository
                            .save(atividadeTimesheetIdiomaAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Atividade Timesheet não Encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        atividadeTimesheetIdiomaRepository
                .findById(id)
                .map(atividadeTimesheetIdioma -> {
                    atividadeTimesheetIdiomaRepository.delete(atividadeTimesheetIdioma);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atividade Timesheet não Encontrada"));
    }
}
