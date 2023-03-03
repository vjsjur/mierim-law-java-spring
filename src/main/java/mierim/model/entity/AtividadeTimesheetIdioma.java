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
@Entity(name = "cad_atividade_timesheet_idioma")
public class AtividadeTimesheetIdioma implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String textopadrao;

    @ManyToOne
    @JoinColumn(name = "id_atividade_timesheet")
    private AtividadeTimesheet atividade_timesheet;

    @ManyToOne
    @JoinColumn(name = "id_itioma")
    private Idioma idioma;
    private String idioma_descricao;
    private String deletado = "2";

}
