package mierim.model.entity.financeiro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.autocontida.Pais;
import mierim.model.entity.autocontida.UnidadeFederativa;
import mierim.model.entity.faturamento.Grupocliente;
import mierim.model.entity.faturamento.Profissional;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_fornecedor")
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"codigo", "id_profissional", "deletado"}, name = "fornecprof_uk")  
)
public class CadFornecedor implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Integer id;
    private String codigo;
    private String loja;
    private String razao_social;
    private String nome;
    private String tipo_pessoa;
    private String cnpj_cpf;
    private int inscr_estadual;
    private int incr_municipal;
    private String status;
    private String perfil;
    private String forma_pagto;
    private String deletado = "2";
    private String rec_iss;
    private String rec_pis;
    private String rec_cofins;
    private String rec_csll;
    private String rec_irrf;
    private double pec_iss;
    private double pec_pis;
    private double pec_cofins;
    private double pec_csll;
    private double pec_irrf;
    private String optante_simples;
    private String modo_abatimento;
    private String for_ret_iss;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional id_profissional;

    @OneToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private UnidadeFederativa estado;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_cliente_grupo")
    private Grupocliente grupoFornecedor;
    private String nome_grupo_fornecedor;
    private String endereco;
    private String bairro;
    private String cep;
    private String envia_email;
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;
    private String banco_nome;
    private Integer banco_numero;
    private Integer banco_agencia_numero;
    private String banco_agencia_nome;
    private String banco_conta_nome;
    private String banco_status;
    private Integer banco_conta_numero;
    private String fornecedor_loja;
    private String fornecedor_loja_razao;
    private LocalDate data_cadastro;

    public void setId_profissional(Profissional id_profissional) {
        this.id_profissional = id_profissional;
    }

}
