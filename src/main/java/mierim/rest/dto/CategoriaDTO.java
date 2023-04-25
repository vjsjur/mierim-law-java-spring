package mierim.rest.dto;

import lombok.Getter;
import lombok.Setter;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CategoriaDTO {
    private Long id;
    private String descricao;
    private String assina_fat;
    private String status;
    private String tecnico;
    private double meta_horas_dia;
    private String deletado;
    private Long Sis_UsuarioId;
    private Date data_inclusao;

}
