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


    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_Company> sis_company;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_CompanyFilial> sis_company_filial;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_Menu> sis_menu;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_MenuGrupo> sis_menu_grupo;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_Perfil> sis_perfil;


    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_Perfil_Aux> sis_perfil_aux;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Sis_ParametroSistema> sis_parametro_sistema;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<UsuarioPerfil> usuario_perfil;

    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<UsuarioProfessor> usuario_professor;


    @OneToMany
    @JoinColumn(name = "id_tenant")
    private List<Usuario> usuario;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sis_CompanyGroup)) return false;
        Sis_CompanyGroup that = (Sis_CompanyGroup) o;
        return getId_tenant().equals(that.getId_tenant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_tenant());
    }
}
