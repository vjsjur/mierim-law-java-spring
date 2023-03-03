package mierim.model.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = UsuarioCondomino.LISTAR_TODOS, query = UsuarioCondomino.LISTAR_TODOS)
})
public class UsuarioCondomino extends Usuario {

	public static final String LISTAR_TODOS = "from UsuarioCondomino";

   
    
    private String perfilAcesso;

    public String getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(String perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
    
}


