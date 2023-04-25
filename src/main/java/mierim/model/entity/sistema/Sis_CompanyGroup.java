package mierim.model.entity.sistema;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.faturamento.Profissional;
import mierim.rest.dto.Sis_CompanyGroupDTO;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_company_group")
public class Sis_CompanyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tenant;

    @Column(nullable=false, length=120)
    private String nome;

    @Column(nullable=false, length=120)
    private String grupo_economico;

    @Column(nullable=false, length=120)
    private String dominio;

    @Column(name = "deletado", length = 1)
    private String deletado;

    @Column(name = "status", length = 1)
    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date data_inclusao = new Date();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date data_alteracao = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "sis_company_group")
    private List<Sis_CompanyEmpresa> sis_company_empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "sis_company_group")
    private List<Sis_CompanyFilial> sis_company_filial;

    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////Retorno dos relacionamentos/////////////////////////
    /////////////////////////////////////////////////////////////////////////////

    @JsonIgnore
    @OneToMany(mappedBy = "sis_group")
    private List<Profissional> profissional;


    public Sis_CompanyGroup(Sis_CompanyGroupDTO objTDO) {
    }
}
