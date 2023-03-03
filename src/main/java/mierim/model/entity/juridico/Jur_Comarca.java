package mierim.model.entity.juridico;

import mierim.model.entity.UnidadeFederativa;
import mierim.model.entity.Pais;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_comarca")
public class Jur_Comarca implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "PREENCHA DESCRIÇÃO!")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais id_pais;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private UnidadeFederativa id_estado;

    @NotEmpty(message = "PREENCHA STATUS!")
    private String status = "1";
    private String deletado = "2";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Jur_Comarca other = (Jur_Comarca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
