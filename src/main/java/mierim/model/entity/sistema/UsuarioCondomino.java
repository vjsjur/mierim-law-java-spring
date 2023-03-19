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
	@NamedQuery(name = UsuarioCondomino.LISTAR_TODOS, query = UsuarioCondomino.LISTAR_TODOS)
})
public class UsuarioCondomino extends Sis_Usuario {

	public static final String LISTAR_TODOS = "from UsuarioCondomino";

    private String perfilAcesso;

}


