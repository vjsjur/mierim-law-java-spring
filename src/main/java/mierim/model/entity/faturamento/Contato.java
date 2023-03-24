package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.rhumanos.Departamento;
import mierim.model.entity.rhumanos.Cargo;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = -4451928900154383946L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Version
    private Long version;
    private String tratamento;
    private String nome;
    private String cpf;
    private String status;
    private String deletado  = "2";
    private String cep;
    private String bairro;
    private String endereco;
    private String complemento;
    private String telefone;
    private String ramal;
    private String celular;
    private String email;
    private String sexo;

    @Transient
    private String filtro;

    @Transient
    private String filtro_tipo;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return getId().equals(contato.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
