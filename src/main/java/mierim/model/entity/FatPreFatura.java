package mierim.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_pre_fatura")
public class FatPreFatura implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inc;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fin;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_timesheet;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_timesheet;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_despesa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_despesa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_tabelado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_tabelado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_parcela;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_parcela;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_ft_adicional;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_ft_adicional;
    private String tem_timesheet;
    private String tem_tabelado;
    private String tem_fixo;
    private String tem_ft_adicional;
    private String tem_despesa;
    private String situacao;
    private String tipo_ajuste;
    private String deletado  = "2";

    @Column(precision = 8, scale = 2)
    private Double valor_timesheet;

    @Column(precision = 8, scale = 2)
    private Double valor_tabelado;

    @Column(precision = 8, scale = 2)
    private Double valor_despesa;

    @Column(precision = 8, scale = 2)
    private Double valor_fixo;

    @Column(precision = 8, scale = 2)
    private Double valor_desconto_linear;

    @Column(precision = 8, scale = 2)
    private Double valor_desconto_especial;

    @Column(precision = 8, scale = 2)
    private Double valor_percentual_especial;

    @Column(precision = 8, scale = 2)
    private Double valor_acrescimo;
    private Moeda moeda;

}
