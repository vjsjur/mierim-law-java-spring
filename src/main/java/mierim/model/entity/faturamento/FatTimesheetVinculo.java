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
@Entity(name = "fat_timesheet_vinculo")
public class FatTimesheetVinculo implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_timesheet")
    private FatTimesheetLancamento id_timesheet;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_trabalho;
    private double ut_lanc;
    private double ut_rev;
    private String hora_lanc;
    private String hora_rev;

    @Column(precision = 11, scale = 8)
    private Double hora_frac_lanc;

    @Column(precision = 11, scale = 8)
    private Double hora_frac_rev;

    @ManyToOne
    @JoinColumn(name = "id_prof_lanc")
    private Profissional prof_lanc;

    @ManyToOne
    @JoinColumn(name = "id_prof_rev")
    private Profissional prof_rev;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_atividade_timesheet")
    private AtividadeTimesheet atividade_timesheet;

    @Column(precision = 11, scale = 8)
    private Double valor_timesheet;

    @Column(precision = 11, scale = 8)
    private Double valor_hora;

    @ManyToOne
    @JoinColumn(name = "id_moeda_lancamento")
    private Moeda moeda_lancamento;

    @ManyToOne
    @JoinColumn(name = "id_moeda_movimento")
    private Moeda moeda_movimento;
    private String deletado = "2";
    private String cancelado = "2";

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura fatprefatura;

    @ManyToOne
    @JoinColumn(name = "id_fatura")
    private FatFatura fatfatura;

    @ManyToOne
    @JoinColumn(name = "id_wo")
    private FatWo fatwo;
    private double cotacao_01;
    private double cotacao_02;
    private double cotacao_03;
    private Integer id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contratocaso;
    private double valor_moeda_movimentacao;
    private double valor_moeda_nacional;

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
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final FatTimesheetVinculo other = (FatTimesheetVinculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
