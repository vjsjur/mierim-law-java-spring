package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.financeiro.Banco;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_cliente")
public class Cliente implements Serializable {

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
    private String tipo_cliente;
    private String cnpj_cpf;
    private int inscr_estadual;
    private int incr_municipal;
    private String status;
    private String perfil;
    private String forma_pagto;

    @ManyToOne
    @JoinColumn(name = "id_prifissional_socio")
    private Profissional profissionalSoc;

    @ManyToOne
    @JoinColumn(name = "id_prifissional_revizor")
    private Profissional profissionalRev;
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
    @JoinColumn(name = "id_cliente_grupo")
    private Grupocliente grupoCliente;
    private String nome_grupo_cliente;
    private String nome_socio;
    private String nome_revisor;

    @ManyToOne
    @JoinColumn(name = "id_escritorio_origem")
    private Escritorio escritorio_origem;
    private String escritorio_origem_nome;

    @ManyToOne
    @JoinColumn(name = "id_escritorio_faturamento")
    private Escritorio escritorio_faturamento;
    private String escritorio_faturamento_nome;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;
    private String pais_nome;
    private String unidade_federativa_nome;

    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    private String endereco;
    private String bairro;
    private String cep;
    private String cria_caso;
    private String envia_email;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;
    private String moeda_descricao;
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;
    private String banco_nome;
    private Integer banco_numero;
    private Integer banco_agencia_numero;
    private String banco_agencia_nome;
    private Integer banco_conta_numero;

    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario")
    private TabelaHonorario tabelaHonorario;
    private String tabela_honorario_descricao;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;
    private String idioma_descricao;
    private String cliente_loja;
    private String cliente_loja_razao;
    private LocalDate data_cadastro;

    @OneToOne
    @JoinColumn(name = "id_tipo_relatorio")
    private TipoRelatorio tipo_relatorio;

    @OneToOne
    @JoinColumn(name = "id_tipo_carta_cobranca")
    private TipoCartaCobranca tipo_carta_cobranca;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @NotNull(message = "Preencha o Usuário de Aleração")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_alteracao")
    private Sis_Usuario sis_usuario_alteracao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha a Empresa!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;

    @NotNull(message = "Preencha a Filial!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
