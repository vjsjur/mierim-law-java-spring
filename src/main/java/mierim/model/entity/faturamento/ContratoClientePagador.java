package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.financeiro.Banco;
import mierim.model.entity.financeiro.FinCondicaoPagamento;

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
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_contrato_cliente_pagador")
public class ContratoClientePagador implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private mierim.model.entity.faturamento.Cliente Cliente;
    private double percentual_faturamento;
    private double desconto_pagador;
    private String forma_pagto;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;
    private String moeda_simbolo;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;
    private String banco_nome;
    private Integer banco_numero;
    private Integer banco_agencia_numero;
    private String banco_agencia_nome;
    private Integer banco_conta_numero;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @ManyToOne
    @JoinColumn(name = "id_contato")
    private Contato contato;
    private Integer contao_codigo;
    private String contato_nome;

    @ManyToOne
    @JoinColumn(name = "id_condicao_pagamento")
    private FinCondicaoPagamento condicao_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_relatorio")
    private TipoRelatorio tipo_relatorio;

    @ManyToOne
    @JoinColumn(name = "id_carta_cobranca")
    private TipoCartaCobranca tipo_carta_cobranca;
    private String deletado = "2";
    private String status = "1";

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_vencimento = new Date();

    @Transient
    private boolean editing;

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
        final ContratoClientePagador other = (ContratoClientePagador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
