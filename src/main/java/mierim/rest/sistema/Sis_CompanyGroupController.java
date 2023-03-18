package mierim.rest.sistema;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.faturamento.Profissional;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.ProfissionalRepository;
import mierim.model.repository.sistema.Sis_CompanyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/company_group")
@RequiredArgsConstructor
public class Sis_CompanyGroupController {

    @Autowired
    private final Sis_CompanyGroupRepository sisCompanyGroupRepository;

    @GetMapping
    public List<Sis_CompanyGroup> findAllCompanyGroup(){
        return sisCompanyGroupRepository
                .findAll();
    }

    @GetMapping("{id}")
    public Sis_CompanyGroup findByIdCompanyGroup(@PathVariable Long id){
        return sisCompanyGroupRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Grupo Econômico não Encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sis_CompanyGroup saveCompanyGroup(@RequestBody @Valid Sis_CompanyGroup sisCompanyGroup){
        return sisCompanyGroupRepository
                .save(sisCompanyGroup);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompanyGroup(@PathVariable Long id, @RequestBody Sis_CompanyGroup sisCompanyGroupUpdate) {
        sisCompanyGroupRepository
                .findById(id)
                .map(companyGroup -> {
                    sisCompanyGroupUpdate
                            .setId_tenant(companyGroup.getId_tenant());
                    return sisCompanyGroupRepository
                            .save(sisCompanyGroupUpdate);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Profissional não Encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompanyGroup(@PathVariable Long id){
        sisCompanyGroupRepository
                .findById(id)
                .map(companyGroup -> {
                    sisCompanyGroupRepository.delete(companyGroup);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo Econônico não Encontrada"));
    }

}
