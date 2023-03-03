package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_caso_excecao_profissional")
public class CasoExcecaoProfissional implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Integer id;
    private String ano_mes_ini;
    private String ano_mes_fin;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    private double valor_original;
    private double valor_alterado;

    @ManyToOne
    @JoinColumn(name = "id_categoria_original")
    private Categoria categoria_original;

    @ManyToOne
    @JoinColumn(name = "id_categoria_alterada")
    private Categoria categoria_alterada;
    private String deletado = "2";

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CasoExcecaoProfissional other = (CasoExcecaoProfissional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    
    
}
