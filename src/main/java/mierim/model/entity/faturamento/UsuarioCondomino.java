package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.sistema.Usuario;

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
public class UsuarioCondomino extends Usuario {

	public static final String LISTAR_TODOS = "from UsuarioCondomino";

    private String perfilAcesso;

}


