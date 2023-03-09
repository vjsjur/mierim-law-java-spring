package mierim.model.entity;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_tabela_honorario_historico_categoria")
public class TabelaHonorarioHistoricoCategoria implements Serializable {

    private static final long serialVersionUID = 4832317533686864537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario")
    private TabelaHonorario tabelaHonorario;
    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario_historico")
    private TabelaHonorarioHistorico tabelaHonorarioHistorico;
    private String ano_mes_ini;
    private String ano_mes_fim;
    private String deletado = "2";
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private double valor_hora;
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.ano_mes_ini);
        hash = 59 * hash + Objects.hashCode(this.ano_mes_fim);
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
        final TabelaHonorarioHistoricoCategoria other = (TabelaHonorarioHistoricoCategoria) obj;
        if (!Objects.equals(this.ano_mes_ini, other.ano_mes_ini)) {
            return false;
        }
        if (!Objects.equals(this.ano_mes_fim, other.ano_mes_fim)) {
            return false;
        }
        return true;
    }

 
}
