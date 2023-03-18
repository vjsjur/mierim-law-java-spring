package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_moeda")
public class Moeda implements Serializable {

    public Moeda(String simbolo_descricao) {
        this.simbolo_descricao = simbolo_descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String simbolo;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;

    @NotEmpty(message = "PREENCHA O SIMBOLO!")
    private String simbolo_descricao;
    private String status;

    @NotNull(message = "PREENCHA A DATA!")
    private Date dt_cadastro;
    private String deletado = "2";

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
