package mierim.model.entity.faturamento;

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
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_emissao_prefatura")
public class FatEmissaoPreFatura implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_ts = new Date(19000101);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_ts = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_tab = new Date(01 / 01 / 1900);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_tab = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_desp = new Date(01 / 01 / 1900);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_desp = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_fx = new Date(01 / 01 / 1900);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_fx = new Date();

    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Profissional socio;

    @ManyToOne
    @JoinColumn(name = "id_revisor")
    private Profissional revisor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "id_grupo_cliente")
    private Grupocliente grupocliente;

    @ManyToOne
    @JoinColumn(name = "id_despesa_tipo")
    private DespesaTipo despesatipo;

    @ManyToOne
    @JoinColumn(name = "id_honorario_tipo")
    private Tipohonorario tipohonorario;
    private String deletado = "2";
    private boolean tem_timesheet ;
    private boolean tem_despesa ;
    private boolean tem_tabelado ;
    private boolean tem_fixo ;

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


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FatEmissaoPreFatura other = (FatEmissaoPreFatura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
