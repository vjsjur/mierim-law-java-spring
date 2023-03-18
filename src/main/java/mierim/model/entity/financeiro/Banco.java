package mierim.model.entity.financeiro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.faturamento.Moeda;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_banco")
public class Banco implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer banco_numero;
    private Integer banco_agencia_numero;
    private Integer banco_conta_numero;
    private String banco_nome;
    private String banco_agencia_nome;
    private String banco_conta_nome;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;
    private String moeda_descicao;

    @NotEmpty(message = "PREENCHA O STATUS!")
    private String status;
    private String deletado = "2";
    private Double saldo;
}
