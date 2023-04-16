package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.autocontida.Pais;
import mierim.model.entity.autocontida.UnidadeFederativa;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_escritorio")
public class Escritorio implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    private String codigo;

    @NotEmpty(message = "PREENCHA O NOME!")
    private String nome;

    @NotEmpty(message = "PREENCHA A RAZÃO SOCIAL!")
    private String razao;

    @NotEmpty(message = "PREENCHA O CNPJ!")
    private String cnpj;

    @NotEmpty(message = "PREENCHA O STATUS")
    private String status;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "PREENCHA A DATA!")
    private Date dt_cadastro;
    private String emite_fat;
    private String emite_nfe;
    private String emite_nfse;
    private String deletado = "2";
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;


    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    private String id_uf;

    private String id_pais;

    @NotNull(message = "Preencha o Usuário de Inclusão")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_inclusao")
    private Sis_Usuario sis_usuario_inclusao;

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
        if (!(o instanceof Escritorio)) return false;
        Escritorio that = (Escritorio) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
