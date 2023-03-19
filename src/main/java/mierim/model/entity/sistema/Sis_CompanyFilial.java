package mierim.model.entity.sistema;

import lombok.*;

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
    private Integer cpf_cnpj;
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
    private String municipio;
    private String uf;

    @Column(nullable=false, length=120)
    private String email;
    @Column(nullable=false, length=15)
    private String telefone;
    @Column(name = "deletado", length = 1)
    private String deletado = "2";

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_Company sis_company;

    @OneToMany
    @JoinColumn(name = "id_tenant_filial")
    private List<Sis_Menu> sis_menu;

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
