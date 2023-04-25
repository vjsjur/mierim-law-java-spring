package mierim.rest.faturamento;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.AtividadeTimesheet;
import mierim.model.entity.faturamento.Cliente;
import mierim.model.repository.faturamento.AtividadeTimesheetRepository;
import mierim.model.repository.faturamento.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/atividadetimesheet/")
@RequiredArgsConstructor
public class AtividadeTimesheetController {

    @Autowired
    private final AtividadeTimesheetRepository atividadeTimesheetRepository;

    @GetMapping
    public List<AtividadeTimesheet> listarTodos(){
        return atividadeTimesheetRepository
                .findAll();
    }

    @GetMapping("{id}")
    public AtividadeTimesheet acharPorId(@PathVariable Integer id){
        return atividadeTimesheetRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Atividade TimeSheet não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtividadeTimesheet salvar(@RequestBody @Valid AtividadeTimesheet atividadeTimesheet){
        return atividadeTimesheetRepository
                .save(atividadeTimesheet);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosCliente(@PathVariable Integer id, @RequestBody AtividadeTimesheet atividadeTimesheetAtualizado) {
        atividadeTimesheetRepository
                .findById(id)
                .map(cliente -> {
                    atividadeTimesheetAtualizado
                            .setId(cliente.getId());
                    return atividadeTimesheetRepository
                            .save(atividadeTimesheetAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Atividade Timesheet não Encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        atividadeTimesheetRepository
                .findById(id)
                .map(atividadeTimesheet -> {
                    atividadeTimesheetRepository.delete(atividadeTimesheet);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atividade Timesheet não Encontrada"));
    }
}
