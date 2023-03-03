package mierim.model.entity;

import mierim.model.entity.juridico.Jur_Indice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_contrato")
public class Contrato implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Long id;
    private String titulo;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente_pagador")
    private Cliente id_cliente_pagador;

    @ManyToOne
    @JoinColumn(name = "id_grupo_cliente")
    private Grupocliente grupocliente;

    @ManyToOne
    @JoinColumn(name = "id_profissional_revisor")
    private Profissional profRev;

    @ManyToOne
    @JoinColumn(name = "id_moeda_prefatura")
    private Moeda moeda_prefatura;

    @ManyToOne
    @JoinColumn(name = "id_moeda_limite_geral")
    private Moeda id_moeda_limite_geral;

    @ManyToOne
    @JoinColumn(name = "id_moeda_limite_fatura")
    private Moeda id_moeda_limite_fatura;

    @ManyToOne
    @JoinColumn(name = "id_moeda_fixo")
    private Moeda id_moeda_fixo;

    @Temporal(TemporalType.DATE)
    private Date data_cadastro = new Date();

    @Temporal(TemporalType.DATE)
    private Date vigencia_de;

    @Temporal(TemporalType.DATE)
    private Date vigencia_ate;

    @ManyToOne
    @JoinColumn(name = "id_tipo_honorario")
    private Tipohonorario tipo_honoratio;

    @ManyToOne
    @JoinColumn(name = "id_escritorio_faturamento")
    private Escritorio escritorio;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;
    private String deletado = "2";
    private String encerra_timesheet;
    private String encerra_despesa;
    private String encerra_tabelado;
    private String cobra_timesheet;
    private String cobra_despesa;
    private String cobra_tabelado;
    private double valor_limite_geral;
    private double valor_limite_geral_utilizado;
    private double valor_limite_geral_saldo;
    private String limite_geral_tabelado;
    private String limite_geral_fat_adicional;
    private double valor_limite_fatura;
    private double valor_limite_fatura_utilizado;
    private double valor_limite_fatura_saldo;
    private String limite_fatura_tabelado;
    private String limite_fatura_fat_adicional;

    @Temporal(TemporalType.DATE)
    private Date data_base;
    private double valor_base;
    private Integer periodicidade_cobranca;

    @Temporal(TemporalType.DATE)
    private Date data_base_atualizacao;
    private double valor_base_atualizacao;
    private Integer periodicidade_atualizacao;

    @ManyToOne
    @JoinColumn(name = "id_indice")
    private Jur_Indice id_indice;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Contrato other = (Contrato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
