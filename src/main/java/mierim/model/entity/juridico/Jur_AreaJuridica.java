package mierim.model.entity.juridico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_area_juridica")
public class Jur_AreaJuridica implements Serializable {


    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    @Column(name = "codigo", length = 10)
    private String codigo;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    @Column(name = "descricao", length = 80)
    private String descricao;

    @NotEmpty(message = "PREENCHA O TÉCNICO")
    @Column(name = "tecnico", length = 1)
    private String tecnico;

    @NotEmpty(message = "PREENCHA O STATUS!")
    @Column(name = "status", length = 1)
    private String status;

    @OneToMany(mappedBy = "jurAreaJuridica")
    @JsonIgnore
    private List<Jur_AreaJuridicaSub> subarea;

    @Column(name = "deletado", length = 1)
    private String deletado = "2";

    @NotNull(message = "Preencha o Usuário de Aleração")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_inclusao")
    private Sis_Usuario sis_usuario_inclusao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @NotNull(message = "Preencha o Usuário de Aleração")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_alteracao")
    private Sis_Usuario sis_usuario_alteracao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha a Empresa!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;

    @NotNull(message = "Preencha a Filial!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;


}
