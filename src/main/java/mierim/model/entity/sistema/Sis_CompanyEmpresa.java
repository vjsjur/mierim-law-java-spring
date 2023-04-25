package mierim.model.entity.sistema;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.faturamento.Profissional;
import mierim.rest.dto.Sis_CompanyEmpresaDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_company_empresa")
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = {"id_tenant_company","id_tenant", "deletado"}, name = "company_tenant_uk"),
                @UniqueConstraint(columnNames = {"id_tenant_company","id_tenant", "deletado", "cpf_cnpj"}, name = "company_cpf_cnpj_uk")
        }
)

public class Sis_CompanyEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tenant_company;
    @Column(nullable = false, length = 13)
    private Long cpf_cnpj;
    @Column(nullable = false, length = 120)
    private String nome_emp;
    @Column(nullable = false, length = 120)
    private String nome_fant;
    @Column(nullable = false, length = 120)
    private String logradouro;
    @Column(nullable = false, length = 15)
    private String numero;
    @Column(length = 60)
    private String complemento;
    @Column(length = 10)
    private String cep;
    @Column(length = 60)
    private String bairro;

    @Column(length = 40)
    private String id_uf;
    @Column(length = 60)
    private String id_pais;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(name = "deletado", length = 1)
    private String deletado;

    @Column(name = "status", length = 1)
    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date data_inclusao = new Date();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date data_alteracao = new Date();
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////Retorno dos relacionamentos/////////////////////////
    /////////////////////////////////////////////////////////////////////////////

    @JsonIgnore
    @OneToMany(mappedBy = "sis_empresa")
    private List<Profissional> profissional;

    @JsonIgnore
    @OneToMany(mappedBy = "sis_empresa")
    private List<Sis_CompanyFilial> sis_company_filial;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sis_CompanyEmpresa)) return false;
        Sis_CompanyEmpresa that = (Sis_CompanyEmpresa) o;
        return getId_tenant_company().equals(that.getId_tenant_company());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId_tenant_company());
    }

    public Sis_CompanyEmpresa(Sis_CompanyEmpresaDTO obj) {
        super();
        this.id_tenant_company = obj.getId_tenant_company();
        this.cpf_cnpj = obj.getCpf_cnpj();
        this.nome_emp = obj.getNome_emp();
        this.nome_fant = obj.getNome_fant();
        this.logradouro = obj.getLogradouro();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.cep = obj.getCep();
        this.bairro = obj.getBairro();
        this.id_uf = obj.getId_uf();
        this.id_pais = obj.getId_pais();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.deletado = obj.getDeletado();
        this.status = obj.getStatus();
        this.data_inclusao = obj.getData_inclusao();
        this.data_alteracao = obj.getData_alteracao();
       // this.municipio = obj.getId_municipio();
      //  this.id_tenant = obj.getId_tenant();
    }

}