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
@Entity(name = "fat_despesa_vinculo")
public class FatDespesaVinculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;

    @ManyToOne
    @JoinColumn(name = "id_moeda_emissao")
    private Moeda moeda_emissao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_despesa = new Date();
    private Double valor_despesa;
    private double valor_moeda_movimentacao;
    private double valor_moeda_nacional;
    private Double cotacao_01;
    private Double cotacao_02;
    private Double cotacao_03;
    private String status = "1";
    private String deletado = "2";
    private String cancelado = "2";

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura fatprefatura;

    @ManyToOne
    @JoinColumn(name = "id_despesa_lancamento")
    private FatDespesaLancamento fat_despesa_lancamento;

    @ManyToOne
    @JoinColumn(name = "id_fatura")
    private FatFatura fatfatura;

    @ManyToOne
    @JoinColumn(name = "id_wo")
    private FatWo fatwo;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contratocaso;

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
        final FatDespesaVinculo other = (FatDespesaVinculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
