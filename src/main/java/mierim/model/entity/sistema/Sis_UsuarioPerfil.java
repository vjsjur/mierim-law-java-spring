package mierim.model.entity.sistema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_usuario_perfil")
public class Sis_UsuarioPerfil implements Serializable {

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
    private Sis_UsuarioComplemento usuarioprofessor;
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

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha a Empresa!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;

    @NotNull(message = "Preencha a Filial!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;

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
        final Sis_UsuarioPerfil other = (Sis_UsuarioPerfil) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
