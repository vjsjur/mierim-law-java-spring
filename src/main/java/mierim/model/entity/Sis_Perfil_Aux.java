package mierim.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
@Entity(name = "sis_perfil_aux")
public class Sis_Perfil_Aux implements Serializable {

    private Integer id;
    private String descricao;
    private String status = "1";
    private String juridico = "1";
    private String deletado = "2";
    private Sis_Perfil id_perfil;
    //  @ManyToMany
    //  @JoinTable(name = "jur_j_atogerencial_perfil",
    //          joinColumns = @JoinColumn(name = "id_perfil"),
    //          inverseJoinColumns = @JoinColumn(name = "id_ato_gerencial"))
    //  private List<Jur_AtoGerencialPerfil> id_ato_gerencial_perfil;

    public Sis_Perfil_Aux() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @NotEmpty(message = "PREENCHA O STATUS!")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJuridico() {
        return juridico;
    }

    public void setJuridico(String juridico) {
        this.juridico = juridico;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    public Sis_Perfil getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Sis_Perfil id_perfil) {
        this.id_perfil = id_perfil;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Sis_Perfil_Aux other = (Sis_Perfil_Aux) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
