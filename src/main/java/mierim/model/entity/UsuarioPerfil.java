package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Sis_Perfil perfil;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioProfessor usuarioprofessor;
    private boolean ativo = false;
    private boolean inclui = true;
    private boolean altera = true;
    private boolean exclui = true;
    private boolean imprime = true;
    private boolean sensiveis = true;
    private boolean pessoais = true;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora_ini;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora_fin;
    private String deletado = "2";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.status);
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
        final UsuarioPerfil other = (UsuarioPerfil) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
