package mierim.model.entity.sistema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_company_group")
public class Sis_CompanyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tenant;

    @Column(nullable=false, length=120)
    private String nome;

    @Column(nullable=false, length=120)
    private String grupo_economico;

    @Column(nullable=false, length=120)
    private String dominio;

    @Column(name = "deletado", length = 1)
    private String deletado = "2";


}
