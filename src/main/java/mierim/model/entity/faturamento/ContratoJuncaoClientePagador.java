package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.financeiro.Banco;
import mierim.model.entity.financeiro.FinCondicaoPagamento;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_contrato_juncao_cliente_pagador")
public class ContratoJuncaoClientePagador implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_contratojuncao")
    private ContratoJuncao id_contratojuncao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;
    private double percentual_faturamento;
    private double desconto_pagador;
    private String forma_pagto;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda id_moeda;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco id_banco;
    private String banco_nome;
    private Integer banco_numero;
    private Integer banco_agencia_numero;
    private String banco_agencia_nome;
    private Integer banco_conta_numero;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma id_idioma;

    @ManyToOne
    @JoinColumn(name = "id_contato")
    private Contato Idcontato;
    private Integer contao_codigo;
    private String contato_nome;

    @ManyToOne
    @JoinColumn(name = "id_condicao_pagamento")
    private FinCondicaoPagamento id_condicao_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_relatorio")
    private TipoRelatorio id_tipo_relatorio;

    @ManyToOne
    @JoinColumn(name = "id_carta_cobranca")
    private TipoCartaCobranca id_tipo_carta_cobranca;
    private String deletado = "2";
    private String status = "1";

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
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ContratoJuncaoClientePagador other = (ContratoJuncaoClientePagador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
