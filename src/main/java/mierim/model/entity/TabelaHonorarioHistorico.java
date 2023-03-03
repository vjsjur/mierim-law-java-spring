package mierim.model.entity;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "cad_tabela_honorario_historico")
public class TabelaHonorarioHistorico implements Serializable {

    private static final long serialVersionUID = 4832317533686864537L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@ManyToOne
        @JoinColumn(name = "id_tabela_honorario")
    private TabelaHonorario tabelaHonorario;
    private String ano_mes_ini;
     private String ano_mes_fim;
    private String deletado  = "2";

    public TabelaHonorarioHistorico(){ 
    }  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    
    public TabelaHonorario getTabelaHonorario() {
        return tabelaHonorario;
    }

    public void setTabelaHonorario(TabelaHonorario tabelaHonorario) {
        this.tabelaHonorario = tabelaHonorario;
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


   
    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }


    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final TabelaHonorarioHistorico other = (TabelaHonorarioHistorico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
  
    
   
}
