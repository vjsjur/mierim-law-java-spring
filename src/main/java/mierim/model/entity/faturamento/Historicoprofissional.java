package mierim.model.entity.faturamento;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.financeiro.Centrocusto;
import mierim.model.entity.rhumanos.Departamento;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_profissional_historico")
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"ano_mes_ini","ano_mes_fim", "id_profissional", "deletado"}, name = "historico_prof_uk"))
public class Historicoprofissional implements Serializable {

    private static final long serialVersionUID = 5106253941744225597L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    @Id
    private String ano_mes_ini;
    private String ano_mes_fim;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_admissao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_demissao;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "id_centro_custo")
    private Centrocusto centrocusto;
    private String part_distribuicao;
    private String socio;
    private String participa_rateio_despesa;
    private String tecnico;
    private String tempo_disponivel;
    private String deletado = "2";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ano_mes_ini);
        hash = 67 * hash + Objects.hashCode(this.ano_mes_fim);
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
        final Historicoprofissional other = (Historicoprofissional) obj;
        if (!Objects.equals(this.ano_mes_ini, other.ano_mes_ini)) {
            return false;
        }
        if (!Objects.equals(this.ano_mes_fim, other.ano_mes_fim)) {
            return false;
        }
        return true;
    }

   
}
