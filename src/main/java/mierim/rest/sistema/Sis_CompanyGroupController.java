package mierim.rest.sistema;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyGroupRepository;
import mierim.rest.dto.sistema.Sis_CompanyGroupDTO;
import mierim.rest.services.Sis_CompanyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/company_group/")
@RequiredArgsConstructor
public class Sis_CompanyGroupController {

    @Autowired
    private final Sis_CompanyGroupRepository sisCompanyGroupRepository;

    @Autowired
    private Sis_CompanyGroupService service;

    //Lista todos
    @GetMapping
    public ResponseEntity<List<Sis_CompanyGroupDTO>> findAll(){
        List<Sis_CompanyGroup> list = service.findAll();
        List<Sis_CompanyGroupDTO> listDTO = list.stream().map(obj -> new Sis_CompanyGroupDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    //Busca Por Id
    @GetMapping("{id}")
    public ResponseEntity<Sis_CompanyGroup> findById(@PathVariable Long id){
        Sis_CompanyGroup obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    //Insere
    @PostMapping
    public ResponseEntity<Sis_CompanyGroup> create(@RequestBody  Sis_CompanyGroup obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(obj.getId_tenant()).toUri();
        return ResponseEntity.created(uri).build();
    }


    //Atualiza
    @PutMapping(value = "{id}")
    public  ResponseEntity<Sis_CompanyGroupDTO> update(@PathVariable Long id, @RequestBody Sis_CompanyGroupDTO objDTO){
            Sis_CompanyGroup newObj = service.update(id, objDTO);
            return ResponseEntity.ok().body(new Sis_CompanyGroupDTO(newObj));
    }


    //Deleta
    @PutMapping(value = "delete/{id}")
    public  ResponseEntity<Sis_CompanyGroupDTO> delete(@PathVariable Long id, @RequestBody Sis_CompanyGroupDTO objDTO){
        Sis_CompanyGroup newObj = service.delete(id, objDTO);
        return ResponseEntity.ok().body(new Sis_CompanyGroupDTO(newObj));
    }



}
