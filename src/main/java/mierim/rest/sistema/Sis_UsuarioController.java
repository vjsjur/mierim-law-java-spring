package mierim.rest.sistema;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.sistema.Sis_Usuario;
import mierim.model.repository.sistema.Sis_UsuarioRepository;
import mierim.rest.exception.UsuarioCadastradoException;
import mierim.service.Sis_UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class Sis_UsuarioController {

    private final Sis_UsuarioService service;
    private final Sis_UsuarioRepository repository;

    @GetMapping
    public List<Sis_Usuario> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Sis_Usuario usuario){
        try{
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }
    }

    @GetMapping("{id}")
    public Sis_Usuario acharPorId(@PathVariable Integer id){
        return  repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuãrio não Encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Sis_Usuario UsuarioAtualizado){
        repository
                .findById(id)
                .map(usuario -> {
                    UsuarioAtualizado.setId(usuario.getId());
                    return repository.save(UsuarioAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Empresa não Encontrado"));
    }

}
