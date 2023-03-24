package mierim.model.entity.faturamento;

import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "cad_cliente_participacao")
public class ClienteParticipacao implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date ano_mes_ini;
    private Date ano_mes_fin;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_originacao")
    private Originacao originacao;
    private String nome;
    private String deletado = "2";

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    private double percentual;
    private transient boolean editing;

    @Transient
    public boolean isEditing() {
        return editing;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @NotNull(message = "Preencha o Usuário de Aleração")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_alteracao")
    private Sis_Usuario sis_usuario_alteracao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();

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
        int hash = 3;
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
        final ClienteParticipacao other = (ClienteParticipacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
