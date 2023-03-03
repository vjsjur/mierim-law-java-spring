package mierim.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    

    public TabelaHonorarioHistoricoCategoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TabelaHonorarioHistorico getTabelaHonorarioHistorico() {
        return tabelaHonorarioHistorico;
    }

    public void setTabelaHonorarioHistorico(TabelaHonorarioHistorico tabelaHonorarioHistorico) {
        this.tabelaHonorarioHistorico = tabelaHonorarioHistorico;
    }

    public String getAno_mes_ini() {
        return ano_mes_ini;
    }

    public void setAno_mes_ini(String ano_mes_ini) {
        this.ano_mes_ini = ano_mes_ini;
    }

    public String getAno_mes_fim() {
        return ano_mes_fim;
    }

    public void setAno_mes_fim(String ano_mes_fim) {
        this.ano_mes_fim = ano_mes_fim;
    }

 

    public TabelaHonorario getTabelaHonorario() {
        return tabelaHonorario;
    }

    public void setTabelaHonorario(TabelaHonorario tabelaHonorario) {
        this.tabelaHonorario = tabelaHonorario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

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
