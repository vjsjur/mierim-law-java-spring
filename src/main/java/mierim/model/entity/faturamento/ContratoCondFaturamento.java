package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_contrato_cond_faturamento")
public class ContratoCondFaturamento implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato id_contrato;
    private double valor_limite_geral;
    private double valor_limite_geral_utilizado;
    private double valor_limite_geral_saldo;
    private String limite_geral_tabelado;
    private String limite_geral_fat_adicional;
    private double valor_limite_fatura;
    private double valor_limite_fatura_utilizado;
    private double valor_limite_fatura_saldo;
    private String limite_fatura_tabelado;
    private String limite_fatura_fat_adicional;
    private String deletado = "2";

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final ContratoCondFaturamento other = (ContratoCondFaturamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
