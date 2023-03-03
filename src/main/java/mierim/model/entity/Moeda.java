package mierim.model.entity;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Entity(name = "cad_moeda")
public class Moeda implements Serializable {

    public Moeda(String simbolo_descricao) {
        this.simbolo_descricao = simbolo_descricao;
    }
    
    

    public Moeda() {
    }

    
    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String simbolo;
    private String descricao;
    private String simbolo_descricao;
    private String status;
    private Date dt_cadastro;
    private String deletado = "2";

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getSimbolo_descricao() {
        return simbolo_descricao;
    }

    public void setSimbolo_descricao(String simbolo_descricao) {
        this.simbolo_descricao = simbolo_descricao;
    }

    
    @NotEmpty(message = "PREENCHA O SIMBOLO!")
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @NotNull(message = "PREENCHA A DATA!")
    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Moeda other = (Moeda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  

}
