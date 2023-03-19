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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_timesheet_lancamento")
public class FatTimesheetLancamento implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_trabalho = new Date();
    private double ut_lanc;
    private double ut_rev;
    private String hora_lanc;
    private String hora_rev;

    @Column(precision = 11, scale = 8)
    private double hora_frac_lanc;

    @Column(precision = 11, scale = 8)
    private double hora_frac_rev;

    @ManyToOne
    @JoinColumn(name = "id_prof_lanc")
    private Profissional prof_lanc;

    @ManyToOne
    @JoinColumn(name = "id_prof_rev")
    private Profissional prof_rev;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contrato_caso;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato id_contrato;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_atividade_timesheet")
    private AtividadeTimesheet atividade_timesheet;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;
    private String observacao;

    @Column(precision = 11, scale = 8)
    private double valor_timesheet;

    @Column(precision = 11, scale = 8)
    private double valor_hora;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;
    private String revisado;
    private String deletado = "2";
    private String status = "1";

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura prefatura;
    private double cotacao_01;
    private double cotacao_02;
    private double cotacao_03;
    private String vazio = null;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FatTimesheetLancamento)) return false;
        FatTimesheetLancamento that = (FatTimesheetLancamento) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
