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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_fatura_adicional")
public class FaturaAdicional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;
    private double valor_timesheet;
    private double valor_despesa;
    private double valor_tabelado;
    private double valor_total;
    private String status;
    private String deletado = "2";
    private char obeservacao;
    private char texto_fatura;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura prefatura;

}
