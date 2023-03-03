package mierim.model.entity;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name = "cad_rel_tipo_relatorio")
public class TipoRelatorio implements Serializable {

  

    private Integer id;
    private String nome;
    private String descricao;
    private String status;
    private String deletado = "2";

    public TipoRelatorio() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "PREENCHA O NOME!")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final TipoRelatorio other = (TipoRelatorio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
