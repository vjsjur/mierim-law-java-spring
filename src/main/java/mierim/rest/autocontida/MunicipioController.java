package mierim.rest.autocontida;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.repository.autocontidas.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/municipio/")
public class MunicipioController {

    @Autowired
    private final MunicipioRepository municipioRepository;

    @GetMapping
    public List<Municipio> listartodos(){
        return municipioRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Municipio acharPorId(@PathVariable Integer id){
        return municipioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Municipio não Encontrado"));
    }

    @GetMapping("/buscasigla/")
    public List<Municipio> pesquisar(
            @RequestParam(value = "siglauf", required = false, defaultValue = "") String siglauf
    ) {
        return municipioRepository.findBySiglaUfMunicipio("%" + siglauf + "%");
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipio salvar(@RequestBody @Valid Municipio municipio){
        return municipioRepository
                .save(municipio);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosMunicipio(@PathVariable Integer id, @RequestBody Municipio municipioAtualizado){
        municipioRepository
                .findById(id)
                .map(municipio -> {
                    municipioAtualizado
                            .setId(municipio.getId());
                    return municipioRepository
                            .save(municipioAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Municipio não Localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        municipioRepository
                .findById(id)
                .map(municipio -> {
                    municipioRepository.delete(municipio);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Municipio não Encontrado"));
    }
}
