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
@Entity(name = "jur_ato_gerencial_perfil")
public class Jur_AtoGerencialPerfil implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_ato_gerencia")
    private Jur_AtoGerencial id_ato_gerencial;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Sis_Perfil id_perfil;
    private String status;
    private String deletado;
    private String juridico;
    private String origem;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Jur_AtoGerencialPerfil other = (Jur_AtoGerencialPerfil) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}