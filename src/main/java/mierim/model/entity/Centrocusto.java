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

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_centro_custo")
public class Centrocusto implements Serializable {

    private static final long serialVersionUID = 3683296743570013529L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    private String codigo;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;
    private String status;

    @NotEmpty(message = "PREENCHA A CLASSE!")
    private String classe;

    @NotEmpty(message = "PREENCHA A CONDIÇÃO!")
    private String condicao;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;
    private String deletado  = "2";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.codigo);
        hash = 83 * hash + Objects.hashCode(this.descricao);
        hash = 83 * hash + Objects.hashCode(this.status);
        hash = 83 * hash + Objects.hashCode(this.classe);
        hash = 83 * hash + Objects.hashCode(this.condicao);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.escritorio);
        hash = 83 * hash + Objects.hashCode(this.deletado);
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
        final Centrocusto other = (Centrocusto) obj;
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.condicao, other.condicao)) {
            return false;
        }
        if (!Objects.equals(this.deletado, other.deletado)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.escritorio, other.escritorio)) {
            return false;
        }
        return true;
    }

}
