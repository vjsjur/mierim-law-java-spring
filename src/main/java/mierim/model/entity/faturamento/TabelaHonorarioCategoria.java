package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.faturamento.Categoria;
import mierim.model.entity.faturamento.TabelaHonorario;

import java.io.Serializable;
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
@Entity(name = "cad_tabela_honorario_categoria")
public class TabelaHonorarioCategoria implements Serializable {

    private static final long serialVersionUID = 4832317533686864537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario" )
    private TabelaHonorario tabelaHonorario;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private double valor_hora;
    private String deletado = "2";

}
