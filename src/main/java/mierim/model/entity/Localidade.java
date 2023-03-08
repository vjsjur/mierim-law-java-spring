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
import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_localidade")
public class Localidade implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private String cliente_codigo;
    private String cliente_loja;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @NotEmpty(message = "PREENCHA O STATUS!")
    private String status;
    private String deletado = "2";
    private Double quilometragem;

}
