package mierim.model.entity.sistema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


}
