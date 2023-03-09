package mierim.model.entity;


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
	@NamedQuery(name = UsuarioAdministrativo.LISTAR_TODOS, query = UsuarioAdministrativo.LISTAR_TODOS)
})
public class UsuarioAdministrativo extends Usuario {

	private static final long serialVersionUID = -5479955455017618076L;

	public static final String LISTAR_TODOS = "from UsuarioAdministrativo";

	private String grauIntrucao;


}
