package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_fornecedor_banco")
@Table(uniqueConstraints
       = @UniqueConstraint(columnNames = {"id_fornecedor", "id_profissional", "banco_numero", "banco_agencia_numero", "banco_conta_numero", "deletado"}, name = "proforbanco_uk"))
public class CadFornecedorBanco implements Serializable {

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
    @JoinColumn(name = "id_fornecedor")
    private CadFornecedor id_fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional id_profissional;
    private String deletado = "2";

}
