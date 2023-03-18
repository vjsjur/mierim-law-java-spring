package mierim.model.entity.financeiro;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.faturamento.Moeda;
import mierim.model.entity.faturamento.Profissional;

import java.io.Serializable;
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
@Entity(name = "fin_natureza_financeira")
public class FinNatureza implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ed_id;
    private double ed_perapos;

    @Column(length = 10)
    private String ed_codigo;

    @Column(length = 120)
    private String ed_descric;

    @Column(length = 1)
    private String ed_calcirf;
    private double ed_percirf;

    @Column(length = 1)
    private String ed_calciss;
    private double ed_perciss;

    @Column(length = 1)
    private String ed_calcins;
    private double ed_percins;

    @Column(length = 1)
    private String ed_calccsl;

    @Column(length = 1)
    private String ed_calccof;

    @Column(length = 1)
    private String ed_calcpis;
    private double ed_perccsl;
    private double ed_perccof;
    private double ed_percpis;

    @Column(length = 20)
    private String ed_conta;

    @Column(length = 1)
    private String ed_dedpis;

    @Column(length = 1)
    private String ed_dedcof;
    private String ed_baseins;

    @Column(length = 1)
    private String ed_calcses;
    private double ed_baseses;
    private double ed_percses;

    @Column(length = 1)
    private String ed_irrfcar;
    private double ed_baseirc;

    @Column(length = 1)
    private String ed_insscar;

    @Column(length = 20)
    private String ed_debito;

    @Column(length = 9)
    private String ed_ccd;

    @Column(length = 9)
    private String ed_itemd;

    @Column(length = 9)
    private String ed_clvldb;

    @Column(length = 20)
    private String ed_credit;

    @Column(length = 9)
    private String ed_ccc;

    @Column(length = 9)
    private String ed_itemc;

    @Column(length = 9)
    private String ed_clvlcr;

    @Column(length = 1)
    private String ed_dedinss;
    private double ed_baseirf;

    @Column(length = 1)
    private String ed_calcfet;
    private double ed_basecof;
    private double ed_basepis;

    @Column(length = 1)
    private String ed_apurpis;

    @Column(length = 1)
    private String ed_apurcof;
    private double ed_pcappis;
    private double ed_pcapcof;

    @Column(length = 1)
    private String ed_calccid;
    private double ed_basecid;
    private double ed_perccid;

    @Column(length = 1)
    private String ed_tipo;

    @Column(length = 10)
    private String ed_pai;

    @Column(length = 1)
    private String ed_uso;

    @Column(length = 3)
    private String ed_grpnat;

    @Column(length = 1)
    private String ed_ratobr;

    @Column(length = 1)
    private String ed_msblql;

    @Column(length = 1)
    private String ed_cond;
    private double ed_redpis;
    private double ed_redcof;

    @Column(length = 4)
    private String ed_tabccz;

    @Column(length = 3)
    private String ed_codccz;

    @Column(length = 2)
    private String ed_gruccz;

    @Column(length = 8)
    private String ed_dtfccz;

    @Column(length = 2)
    private String ed_clasfis;

    @Column(length = 2)
    private String ed_recirrf;

    @Column(length = 8)
    private String ed_dtinclu;

    @Column(length = 8)
    private String ed_cddeda;

    @Column(length = 8)
    private String ed_msexp;

    @Column(length = 1)
    private String ed_tpreg;

    @Column(length = 8)
    private String ed_cdreca;

    @Column(length = 1)
    private String ed_indcmlt;

    @Column(length = 10)
    private String ed_natmt;

    @Column(length = 10)
    private String ed_natdc;

    @Column(length = 1)
    private String ed_movbco;

    @Column(length = 2)
    private String ed_indret;

    @Column(length = 1)
    private String ed_tpapos;

    @Column(length = 1)
    private String ed_pccindv;

    @Column(length = 2)
    private String ed_cstpis;

    @Column(length = 2)
    private String ed_cstcof;

    @Column(length = 4)
    private String ed_codret;

    @Column(length = 1)
    private String ed_escrit;

    @Column(length = 1)
    private String ed_grpjur;

    @Column(length = 1)
    private String ed_jurcap;

    @Column(length = 1)
    private String ed_rinsspa;

    @Column(length = 1)
    private String ed_recdac;

    @Column(length = 20)
    private String ed_idhist;

    @Column(length = 15)
    private String ed_cdrecsl;

    @Column(length = 1)
    private String ed_jurspd;

    @Column(length = 1)
    private String ed_recfun;

    @Column(length = 1)
    private String ed_f100;

    @Column(length = 10)
    private String ed_natjr;
    private double ed_perciof;

    @ManyToOne
    @JoinColumn(name = "ed_cmoejur")
    private Moeda ed_cmoejur;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional id_profissional;

    @Column(length = 20)
    private String ed_dmoejur;

    @Column(length = 1)
    private String ed_tpcojr;

    @Column(length = 1)
    private String ed_cfjur;

    @Column(length = 1)
    private String ed_cpjur;

    @Column(length = 1)
    private String ed_crjur;

    @Column(length = 1)
    private String ed_bancjur;

    @ManyToOne
    @JoinColumn(name = "ed_cbanco")
    private Banco ed_cbanco;
    private Integer ed_nbanco;
    private Integer ed_cagenc;
    private Integer ed_cconta;

    @Column(length = 1)
    private String ed_ccjuri;

    @Column(length = 10)
    private String ed_ratjur;

    @Column(length = 1)
    private String ed_calcinp;
    private double ed_percinp;

    @Column(length = 1)
    private String ed_calcfmp;

    @Column(length = 1)
    private String deletado;
    private double ed_perqfmp;

}
