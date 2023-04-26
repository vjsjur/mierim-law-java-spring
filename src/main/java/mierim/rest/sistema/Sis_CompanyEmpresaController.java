package mierim.rest.sistema;

import lombok.RequiredArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.repository.sistema.Sis_CompanyEmpresaRepository;
import mierim.rest.dto.sistema.Sis_CompanyEmpresaDTO;
import mierim.rest.dto.sistema.Sis_CompanyGroupDTO;
import mierim.rest.services.Sis_CompanyEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.faces.annotation.RequestParameterMap;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/company_empresa/")
@RequiredArgsConstructor
public class Sis_CompanyEmpresaController {

    @Autowired
    private final Sis_CompanyEmpresaRepository repository;

    @Autowired
    private Sis_CompanyEmpresaService service;


    @GetMapping
    public ResponseEntity<List<Sis_CompanyEmpresaDTO>> findAll(){
        List<Sis_CompanyEmpresa> list = service.findAll();
        List<Sis_CompanyEmpresaDTO> listDTO = list.stream().map(obj -> new Sis_CompanyEmpresaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Sis_CompanyEmpresaDTO> findById(@PathVariable Long id){
        Sis_CompanyEmpresa obj = service.findById(id);
        return ResponseEntity.ok().body( new Sis_CompanyEmpresaDTO(obj));
    }


    @PostMapping
    public ResponseEntity<Sis_CompanyEmpresa> create(@RequestBody  Sis_CompanyEmpresa obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(obj.getId_tenant_company()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //Atualiza
    @PutMapping(value = "{id}")
    public  ResponseEntity<Sis_CompanyEmpresaDTO> update(@PathVariable Long id, @RequestBody Sis_CompanyEmpresaDTO objDTO){
        Sis_CompanyEmpresa newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new Sis_CompanyEmpresaDTO(newObj));
    }


    //Deleta
    @PutMapping(value = "delete/{id}")
    public  ResponseEntity<Sis_CompanyEmpresaDTO> delete(@PathVariable Long id, @RequestBody Sis_CompanyEmpresaDTO objDTO){
        Sis_CompanyEmpresa newObj = service.delete(id, objDTO);
        return ResponseEntity.ok().body(new Sis_CompanyEmpresaDTO(newObj));
    }


    @GetMapping(value = "porgroup")
    public ResponseEntity<List<Sis_CompanyEmpresaDTO>> findAllPorGroup(@RequestParam(value = "group", defaultValue = "0") Long idGroup){
        List<Sis_CompanyEmpresa> list = service.findAllGroup(idGroup);
        List<Sis_CompanyEmpresaDTO> listDTO = list.stream().map(obj -> new Sis_CompanyEmpresaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
