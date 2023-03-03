package mierim.model.entity.juridico;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_ato")
public class Jur_Ato implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String texto_padrao;

    @ManyToOne
    @JoinColumn(name = "id_fase")
    private Jur_Fase id_fase;
    private String status = "1";
    private String deletado = "2";


}
