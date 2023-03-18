package mierim.model.entity.autocontida;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_calendario_anual")
public class CalendarioAnual implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    private Integer id;
    private Integer dia;
    private Integer mes;
    private Integer ano;
    private String dia_semana;
    private Date data;
    private String mes_extenso;

}
