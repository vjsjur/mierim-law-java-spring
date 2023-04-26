package mierim.rest.juridico;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_TipoPedido;
import mierim.model.repository.juridico.Jur_TipoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jur_tipopedido/")
@RequiredArgsConstructor
public class Jur_TipoPedidoController{

    @Autowired
    private final Jur_TipoPedidoRepository jur_TipoPedidoRepository;

    @GetMapping
    public List<Jur_TipoPedido> listarTodos(){
        return jur_TipoPedidoRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Jur_TipoPedido acharPorId(@PathVariable Long id){
        return jur_TipoPedidoRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Pedido não Encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jur_TipoPedido salvar(@RequestBody @Valid Jur_TipoPedido jur_TipoPedido){
        return jur_TipoPedidoRepository
                .save(jur_TipoPedido);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosJur_TipoPedido(@PathVariable Long id, @RequestBody Jur_TipoPedido jur_TipoPedidoAtualizado) {
        jur_TipoPedidoRepository
                .findById(id)
                .map(jur_TipoValor -> {
                    jur_TipoPedidoAtualizado
                            .setId(jur_TipoValor.getId());
                    return jur_TipoPedidoRepository
                            .save(jur_TipoPedidoAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tipo de Valor não Encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        jur_TipoPedidoRepository
                .findById(id)
                .map(jur_TipoPedidol -> {
                    jur_TipoPedidoRepository.delete(jur_TipoPedidol);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Pedido não Encontrada"));
    }

}
