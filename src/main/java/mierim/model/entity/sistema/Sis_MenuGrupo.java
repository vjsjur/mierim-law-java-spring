package mierim.model.entity.sistema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_menu_grupo")
public class Sis_MenuGrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String modulo;

    private String deletado = "2";


    private String sistema;


    @OneToMany
    @JoinColumn(name = "id_menu_grupo")
    private List<Sis_Menu> menu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sis_MenuGrupo)) return false;
        Sis_MenuGrupo that = (Sis_MenuGrupo) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
