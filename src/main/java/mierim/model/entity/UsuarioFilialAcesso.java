package mierim.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Administrator
 */

@Entity
public class UsuarioFilialAcesso implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioProfessor usuarioprofessor;
    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;
    private boolean acessa;
    private String deletado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public UsuarioProfessor getUsuarioprofessor() {
        return usuarioprofessor;
    }

    public void setUsuarioprofessor(UsuarioProfessor usuarioprofessor) {
        this.usuarioprofessor = usuarioprofessor;
    }


 
    public Escritorio getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }

    public boolean isAcessa() {
        return acessa;
    }

    public void setAcessa(boolean acessa) {
        this.acessa = acessa;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final UsuarioFilialAcesso other = (UsuarioFilialAcesso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
