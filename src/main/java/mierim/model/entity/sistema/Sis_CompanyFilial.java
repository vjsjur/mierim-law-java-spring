package mierim.model.entity.sistema;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import mierim.model.entity.autocontida.Municipio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    private String id_uf;

    private String id_pais;

    @Column(nullable=false, length=120)
    private String email;
    @Column(nullable=false, length=15)
    private String telefone;
    @Column(name = "deletado", length = 1)
    private String deletado = "2";

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    @JsonBackReference
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha Empresa!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    @JsonBackReference
    private Sis_CompanyEmpresa sis_empresa;


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
