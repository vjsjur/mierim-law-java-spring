package mierim.model.entity;

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

/**
 *
 * @author Administrator
 */
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

    public UsuarioPerfil() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sis_Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Sis_Perfil perfil) {
        this.perfil = perfil;
    }

    public UsuarioProfessor getUsuarioprofessor() {
        return usuarioprofessor;
    }

    public void setUsuarioprofessor(UsuarioProfessor usuarioprofessor) {
        this.usuarioprofessor = usuarioprofessor;
    }

    public boolean isSensiveis() {
        return sensiveis;
    }

    public void setSensiveis(boolean sensiveis) {
        this.sensiveis = sensiveis;
    }

    public boolean isPessoais() {
        return pessoais;
    }

    public void setPessoais(boolean pessoais) {
        this.pessoais = pessoais;
    }

   


    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isInclui() {
        return inclui;
    }

    public void setInclui(boolean inclui) {
        this.inclui = inclui;
    }

    public boolean isAltera() {
        return altera;
    }

    public void setAltera(boolean altera) {
        this.altera = altera;
    }

    public boolean isExclui() {
        return exclui;
    }

    public void setExclui(boolean exclui) {
        this.exclui = exclui;
    }

    public boolean isImprime() {
        return imprime;
    }

    public void setImprime(boolean imprime) {
        this.imprime = imprime;
    }

    public Date getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(Date hora_ini) {
        this.hora_ini = hora_ini;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
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
