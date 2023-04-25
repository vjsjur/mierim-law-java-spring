package mierim.model.entity.sistema;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.faturamento.Profissional;

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
@Entity(name = "sis_company_filial")
public class Sis_CompanyFilial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tenant_filial;
    @Column(nullable=false)
    private Long cpf_cnpj;
    @Column(nullable=false, length=120)
    private String nome_emp;
    @Column(nullable=false, length=120)
    private String nome_fant;
    @Column(nullable=false, length=120)
    private String logradouro;
    @Column(nullable=false, length=15)
    private String numero;
    @Column(nullable=false, length=60)
    private String complemento;
    @Column(nullable=false, length=10)
    private String cep;
    @Column(nullable=false, length=60)
    private String bairro;

    private String id_uf;

    private String id_pais;

    @Column(nullable=false, length=120)
    private String email;
    @Column(nullable=false, length=15)
    private String telefone;
    @Column(name = "deletado", length = 1)
    private String deletado;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date data_inclusao = new Date();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_alteracao = new Date();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha Empresa!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;


    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////Retorno dos relacionamentos/////////////////////////
    /////////////////////////////////////////////////////////////////////////////

    @JsonIgnore
    @OneToMany(mappedBy = "sis_filial")
    private List<Profissional> profissional;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sis_CompanyFilial)) return false;
        Sis_CompanyFilial that = (Sis_CompanyFilial) o;
        return getId_tenant_filial().equals(that.getId_tenant_filial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_tenant_filial());
    }
}
