package mierim.model.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = UsuarioProfessor.LISTAR_TODOS, query = UsuarioProfessor.LISTAR_TODOS)
})
public class UsuarioProfessor extends Usuario {

    private static final long serialVersionUID = -5479955455017618076L;

    public static final String LISTAR_TODOS = "from UsuarioProfessor";

    private String grauIntrucao;
    private String usuario_ad;
    
    
        

    public String getGrauIntrucao() {
        return grauIntrucao;
    }

    public void setGrauIntrucao(String grauIntrucao) {
        this.grauIntrucao = grauIntrucao;
    }

    public String getUsuario_ad() {
        return usuario_ad;
    }

    public void setUsuario_ad(String usuario_ad) {
        this.usuario_ad = usuario_ad;
    }

    
    
}
