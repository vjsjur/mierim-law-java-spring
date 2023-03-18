package mierim.model.entity.compras;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.excptions.NegocioException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
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
@Entity(name = "cad_produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estoque;
    private String descricao;
    private Date data_cadastro;
    private double valor = 0;
    private String unidade;
    private String deletado = "2";
    private String status;
    private String nome;
    private String sku;
    private BigDecimal valorUnitario;
    private Integer quantidadeEstoque;
    @ManyToOne
    @JoinColumn(name = "id_categoria_produto")
    private CategoriaProduto categoriaProduto;
    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;

    public static final String buscarPorCodigo = "select cad_produto where id = :id";

    public void baixarEstoque(Integer quantidade) throws NegocioException {
        int novaQuantidade = this.getQuantidadeEstoque() - quantidade;

        if (novaQuantidade < 0) {
            throw new NegocioException("Não há disponibilidade no estoque de "
                    + quantidade + " itens do produto " + this.getSku() + ".");
        }

        this.setQuantidadeEstoque(novaQuantidade);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", estoque=" + estoque + ", descricao=" + descricao + ", data_cadastro=" + data_cadastro + ", valor=" + valor + ", unidade=" + unidade + ", deletado=" + deletado + ", status=" + status + ", nome=" + nome + ", sku=" + sku + ", valorUnitario=" + valorUnitario + ", quantidadeEstoque=" + quantidadeEstoque + ", categoriaProduto=" + categoriaProduto + ", fabricante=" + fabricante + '}';
    }

}
