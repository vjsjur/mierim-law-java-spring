package mierim.model.entity.faturamento;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_fechamento_periodo_faturamento")
@Table(uniqueConstraints
       = @UniqueConstraint(columnNames = {"ano_mes", "modulo", "deletado"}, name = "fechamento_uk"))
public class FechamentoPeriodoFaturamento implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ano_mes;
    private String modulo;
    private String status;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_alteracao;
    private String observacao;
    private String deletado = "2";

}
