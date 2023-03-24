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
@Entity(name = "fat_prefatura_contrato")
public class FatPrefaturaContrato implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "id_contrato_juncao")
    private ContratoJuncao id_contrato_juncao;

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura id_prefatura;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;

    private String deletado = "2";
    private double valor_timesheet;
    private double valor_timesheet_moeda_nacional;
    private double valor_despesa;
    private double valor_despesa_moeda_nacional;
    private double valor_fixo;
    private double valor_fixo_moeda_nacional;
    private double valor_desconto;
    private double valor_desconto_moeda_nacional;
    private double valor_acrescimo;
    private double valor_acrescimo_moeda_nacional;

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
        final FatPrefaturaContrato other = (FatPrefaturaContrato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
