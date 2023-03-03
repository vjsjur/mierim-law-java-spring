package mierim.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "cad_tabela_honorario_categoria")
public class TabelaHonorarioCategoria implements Serializable {

    private static final long serialVersionUID = 4832317533686864537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario" )
    private TabelaHonorario tabelaHonorario;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private double valor_hora;
    private String deletado = "2";

    public TabelaHonorarioCategoria() {
    }

    public TabelaHonorarioCategoria(TabelaHonorario tabelaHonorario, Categoria categoria) {
        this.tabelaHonorario = tabelaHonorario;
        this.categoria = categoria;
      
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

   
   
}
