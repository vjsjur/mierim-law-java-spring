package mierim.rest.sistema;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.juridico.Jur_AreaJuridica;
import mierim.model.entity.juridico.Jur_TipoPedido;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyEmpresaRepository;
import mierim.rest.dto.Sis_CompanyEmpresaDTO;
import mierim.rest.dto.Sis_CompanyGroupDTO;
import mierim.rest.exception.ObjectNotFoundException;
import mierim.rest.services.Sis_CompanyEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/company_empresa/")
@RequiredArgsConstructor
public class Sis_CompanyEmpresaController {

    @Autowired
    private final Sis_CompanyEmpresaRepository sisCompanyEmpresaRepository;

    @Autowired
    private Sis_CompanyEmpresaService empresaService;


    @GetMapping
    public ResponseEntity<List<Sis_CompanyEmpresaDTO>> findAllTodos(){
        List<Sis_CompanyEmpresa> list = sisCompanyEmpresaRepository.findAll();
        List<Sis_CompanyEmpresaDTO> listDTO = list.stream().map(obj -> new Sis_CompanyEmpresaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Sis_CompanyEmpresaDTO> findById(@PathVariable Long id){
        Sis_CompanyEmpresa obj = empresaService.findById(id);
        return ResponseEntity.ok().body( new Sis_CompanyEmpresaDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sis_CompanyEmpresa salvar(@RequestBody @Valid Sis_CompanyEmpresa empresa){
        return sisCompanyEmpresaRepository
                .save(empresa);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompanyEmpresa(@PathVariable Long id, @RequestBody Sis_CompanyEmpresa sisCompanyEmpresaUpdate) {
        sisCompanyEmpresaRepository
                .findById(id)
                .map(companyEmpresa -> {
                    sisCompanyEmpresaUpdate
                            .setId_tenant_company
                            (companyEmpresa.getId_tenant_company());
                    return sisCompanyEmpresaRepository
                            .save(sisCompanyEmpresaUpdate);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Empresa não Encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompanyEmpresa(@PathVariable Long id){
        sisCompanyEmpresaRepository
                .findById(id)
                .map(companyEmpresa -> {
                    sisCompanyEmpresaRepository.delete(companyEmpresa);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não Encontrada"));
    }

}
