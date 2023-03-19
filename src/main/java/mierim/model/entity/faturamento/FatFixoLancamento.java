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
@Entity(name = "fat_fixo_lancamento")
public class FatFixoLancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso id_caso;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda id_moeda;

    @ManyToOne
    @JoinColumn(name = "id_moeda_movimento")
    private Moeda id_moeda_movimento;

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura id_prefatura;

    @ManyToOne
    @JoinColumn(name = "id_fatura")
    private FatFatura id_fatura;

    @ManyToOne
    @JoinColumn(name = "id_wo")
    private FatWo id_wo;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato id_contrato;
    private double cotacao_01;
    private double cotacao_02;
    private double cotacao_03;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inicio;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_base;
    private double percentual_corr;
    private double valor;
    private double valor_corrigido;
    private double valor_moeda_nacional;
    private  String deletado = "2";
    private  String status = "1";

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
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final FatFixoLancamento other = (FatFixoLancamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
