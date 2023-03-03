package mierim.model.entity.juridico;

import mierim.model.entity.Sis_Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_fase_perfil")
public class Jur_FasePerfil implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_fase")
    private Jur_Fase id_fase;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Sis_Perfil id_perfil;
    private String status ;
    private String deletado ;
    private String juridico;
    private String origem;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Jur_FasePerfil other = (Jur_FasePerfil) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

 
}
