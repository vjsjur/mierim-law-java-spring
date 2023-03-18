package mierim.model.entity.faturamento;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_lancamento_tabelado_servico")
public class LancamentoTabeladoServico implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String inpi;
    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;
    private String narrativa;
    private String lanca_timesheet;
    private String cobra_maior;
    private String status;
    private String deletado = "2";
    @ManyToOne
    @JoinColumn(name = "id_despesa_tipo")
    private DespesaTipo despesa_tipo;
    private Integer despesa_tipo_codigo;
    @ManyToOne
    @JoinColumn(name = "id_lancamento_tabelado_tipo")
    private LancamentoTabeladoTipo lancamento_tabelado_tipo;
    private Integer lancamento_tabelado_tipo_codigo;

    @Override
    public int hashCode() {
        int hash = 3;
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
        final LancamentoTabeladoServico other = (LancamentoTabeladoServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
