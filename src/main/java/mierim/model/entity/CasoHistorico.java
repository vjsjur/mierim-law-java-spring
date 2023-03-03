package mierim.model.entity;

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
import javax.persistence.TemporalType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_caso_historico")
public class CasoHistorico implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Integer id;

    @Column(name = "cobravel", length = 1)
    private String cobravel;

    @ManyToOne
    @JoinColumn(name = "id_profissional_revisor")
    private Profissional profRev;

    @ManyToOne
    @JoinColumn(name = "id_profissional_socio")
    private Profissional profSoc;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "deletado", length = 1)
    private String deletado = "2";

    @Column(name = "encerra_timesheet", length = 1)
    private String encerra_timesheet;

    @Column(name = "encerra_despesa", length = 1)
    private String encerra_despesa;

    @Column(name = "encerra_tabelado", length = 1)
    private String encerra_tabelado;

    @Column(name = "cobra_timesheet", length = 1)
    private String cobra_timesheet;

    @Column(name = "cobra_despesa", length = 1)
    private String cobra_despesa;

    @Column(name = "cobra_tabelado", length = 1)
    private String cobra_tabelado;

    @Column(name = "tipo_execao", length = 10)
    private String tipo_execao;
    private double valor_excecao = 0;

    @Temporal(TemporalType.DATE)
    private Date data_encerramento;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_area_juridica")
    private Area id_area_juridica;

    @ManyToOne
    @JoinColumn(name = "id_subarea_juridica")
    private SubArea id_subarea_juridica;

    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio id_escritorio;

    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario")
    private TabelaHonorario tabelaHonorario;

    @ManyToOne
    @JoinColumn(name = "id_lancamento_tabelado_tabela")
    private LancamentoTabeladoTabela tabelaServico;

    @Column(name = "ano_mes_fim", length = 7)
    private String ano_mes_fim;

    @Column(name = "ano_mes_ini", length = 7)
    private String ano_mes_ini;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final CasoHistorico other = (CasoHistorico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
