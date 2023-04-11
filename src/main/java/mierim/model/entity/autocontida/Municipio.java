package mierim.model.entity.autocontida;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_municipio")
public class Municipio implements Serializable {

    @Id
    private Integer id;
    private Integer idRec;
    private Integer idRecStatus;
    private String CodUf;
    private String SiglaUf;
    private String NomeUf;
    private String CodMesorGeog;
    private String NomeMesor;
    private String CodMicrorGeog;
    private String NomeMicror;
    private String CodMun;
    private String CodMunComp;
    private String NomeMun;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
