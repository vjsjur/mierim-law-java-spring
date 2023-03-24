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
@Entity(name = "fat_pre_fatura")
public class FatPreFatura implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inc;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fin;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_timesheet;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_timesheet;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_despesa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_despesa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_tabelado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_tabelado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_parcela;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_parcela;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_ft_adicional;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_ft_adicional;
    private String tem_timesheet;
    private String tem_tabelado;
    private String tem_fixo;
    private String tem_ft_adicional;
    private String tem_despesa;
    private String situacao;
    private String tipo_ajuste;
    private String deletado  = "2";

    @Column(precision = 8, scale = 2)
    private Double valor_timesheet;

    @Column(precision = 8, scale = 2)
    private Double valor_tabelado;

    @Column(precision = 8, scale = 2)
    private Double valor_despesa;

    @Column(precision = 8, scale = 2)
    private Double valor_fixo;

    @Column(precision = 8, scale = 2)
    private Double valor_desconto_linear;

    @Column(precision = 8, scale = 2)
    private Double valor_desconto_especial;

    @Column(precision = 8, scale = 2)
    private Double valor_percentual_especial;

    @Column(precision = 8, scale = 2)
    private Double valor_acrescimo;
    private Moeda moeda;

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
        if (!(o instanceof FatPreFatura)) return false;
        FatPreFatura that = (FatPreFatura) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
