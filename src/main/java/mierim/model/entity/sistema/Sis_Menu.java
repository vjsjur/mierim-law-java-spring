package mierim.model.entity.sistema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_menu")
public class Sis_Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "PREENCHA O GRUPO")
    private String nome;

    private String descricao;
    @NotEmpty(message = "PREENCHA O STATUS!")
    private String status;

    private String deletado = "2";

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_menu_grupo")
    private Sis_MenuGrupo menugrupo;

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
        if (!(o instanceof Sis_Menu)) return false;
        Sis_Menu sisMenu = (Sis_Menu) o;
        return getId().equals(sisMenu.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
