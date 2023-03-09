package mierim.model.entity;

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

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_tipo_fatura")
public class TipoFatura implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;
    @NotEmpty(message = "PREENCHA O STATUS!")
    private String status;
    private Date dt_cadastro = new Date();
    private String deletado  = "2";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final TipoFatura other = (TipoFatura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


    

}
