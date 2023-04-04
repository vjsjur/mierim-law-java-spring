package mierim.rest.sistema;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.repository.sistema.Sis_CompanyEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/company_empresa")
@RequiredArgsConstructor
public class Sis_CompanyEmpresaController {

    @Autowired
    private final Sis_CompanyEmpresaRepository sisCompanyEmpresaRepository;

    @GetMapping
    public List<Sis_CompanyEmpresa> findAllCompanyEmpresa(){
        return sisCompanyEmpresaRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Sis_CompanyEmpresa findByIdCompanyEmpresa(@PathVariable Long id){
        return sisCompanyEmpresaRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Empresa não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sis_CompanyEmpresa saveCompanyEmpresa(@RequestBody @Valid Sis_CompanyEmpresa sisCompanyEmpresa){
        return sisCompanyEmpresaRepository
                .save(sisCompanyEmpresa);
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
