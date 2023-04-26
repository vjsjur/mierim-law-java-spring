package mierim.rest.dto.sistema;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mierim.model.entity.sistema.Sis_CompanyGroup;


import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class Sis_CompanyGroupDTO implements Serializable {
    private static final long serialVersionUID = 0L;

    protected Long id_tenant;
    protected String nome;
    protected String grupo_economico;
    protected String dominio;
    protected String deletado;
    protected String status;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_inclusao = new Date();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_alteracao = new Date();

    public Sis_CompanyGroupDTO(){
             super();
    }

    public Sis_CompanyGroupDTO(Sis_CompanyGroup obj){
        this.id_tenant = obj.getId_tenant();
        this.nome = obj.getNome();
        this.grupo_economico = obj.getGrupo_economico();
        this.dominio = obj.getDominio();
        this.deletado = obj.getDeletado();
        this.status = obj.getStatus();
        this.data_inclusao = obj.getData_inclusao();
        this.data_alteracao = obj.getData_inclusao();
    }

}
