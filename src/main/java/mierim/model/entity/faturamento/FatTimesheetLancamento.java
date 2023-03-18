package mierim.model.entity.faturamento;


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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_timesheet_lancamento")
public class FatTimesheetLancamento implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_trabalho = new Date();
    private double ut_lanc;
    private double ut_rev;
    private String hora_lanc;
    private String hora_rev;

    @Column(precision = 11, scale = 8)
    private double hora_frac_lanc;

    @Column(precision = 11, scale = 8)
    private double hora_frac_rev;

    @ManyToOne
    @JoinColumn(name = "id_prof_lanc")
    private Profissional prof_lanc;

    @ManyToOne
    @JoinColumn(name = "id_prof_rev")
    private Profissional prof_rev;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contrato_caso;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato id_contrato;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_atividade_timesheet")
    private AtividadeTimesheet atividade_timesheet;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;
    private String observacao;

    @Column(precision = 11, scale = 8)
    private double valor_timesheet;

    @Column(precision = 11, scale = 8)
    private double valor_hora;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;
    private String revisado;
    private String deletado = "2";
    private String status = "1";

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura prefatura;
    private double cotacao_01;
    private double cotacao_02;
    private double cotacao_03;
    private String vazio = null;

}
