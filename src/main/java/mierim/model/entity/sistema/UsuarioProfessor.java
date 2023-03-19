package mierim.model.entity.sistema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedQueries({
    @NamedQuery(name = UsuarioProfessor.LISTAR_TODOS, query = UsuarioProfessor.LISTAR_TODOS)
})
public class UsuarioProfessor extends Usuario {

    private static final long serialVersionUID = -5479955455017618076L;

    public static final String LISTAR_TODOS = "from UsuarioProfessor";

    private String grauIntrucao;
    private String usuario_ad;

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;


}
