package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
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
