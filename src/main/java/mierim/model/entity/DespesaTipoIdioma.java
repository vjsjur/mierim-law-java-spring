package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
@Entity(name = "cad_despesa_tipo_idioma")
public class DespesaTipoIdioma implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_despesa_tipo")
    private DespesaTipo despesa_tipo;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;
    private String texto_padao;
    private String descricao;
    private String deletado = "2";

}
