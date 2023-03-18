package mierim.model.entity.sistema;


import lombok.*;
import mierim.model.entity.juridico.Area;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_company")
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = {"id","tenant", "deletado"}, name = "company_tenant_uk"),
                @UniqueConstraint(columnNames = {"id","tenant", "deletado", "cpf_cnpj"}, name = "company_cpf_cnpj_uk")
        }
)
public class Sis_Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @NotNull(message = "PREENCHA A ÁREA!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant")
    private Sis_Company sis_company;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sis_Company)) return false;
        Sis_Company that = (Sis_Company) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
