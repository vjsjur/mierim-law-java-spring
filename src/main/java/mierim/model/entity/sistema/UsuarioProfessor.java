package mierim.model.entity.sistema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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


}
