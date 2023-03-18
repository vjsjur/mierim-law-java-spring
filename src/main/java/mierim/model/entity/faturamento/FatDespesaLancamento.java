package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_despesa_lancamento")
public class FatDespesaLancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "id_profissional_revisor")
    private Profissional profissional_revisor;

    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;

    @ManyToOne
    @JoinColumn(name = "id_moeda_movimento")
    private Moeda moeda_movimento;
    private double cotacao_01;
    private double cotacao_02;
    private double cotacao_03;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_despesa = new Date();
    private double valor;
    private double valor_moeda_nacional;
    private String status = "1";
    private String deletado = "2";

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura prefatura;

    @ManyToOne
    @JoinColumn(name = "id_fatura")
    private FatFatura fatura;

    @ManyToOne
    @JoinColumn(name = "id_wo")
    private FatWo fatwo;

    @ManyToOne
    @JoinColumn(name = "id_despesa_tipo")
    private DespesaTipo despeda_tipo;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contrato_caso;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato id_contrato;
    private String observacao;

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
        final FatDespesaLancamento other = (FatDespesaLancamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
