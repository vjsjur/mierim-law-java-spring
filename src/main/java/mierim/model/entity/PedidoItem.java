package mierim.model.entity;

/**
 *
 * @author Administrator
 */
import java.io.Serializable;
import java.math.BigDecimal;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "com_pedido_item")
public class PedidoItem implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String buscarPorCodigo = "select com_pedido_item where id = :id";

    private Integer id;
    private Integer quantidade;
    private BigDecimal valor_parcial;
    private Produto produto;
    private Pedido pedido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }




    @Column(nullable = false, length = 3)
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Column(name = "valor_parcial", precision = 10, scale = 2)
    public BigDecimal getValor_Parcial() {
        return valor_parcial;
    }

    public void setValor_Parcial(BigDecimal valor_parcial) {
        this.valor_parcial = valor_parcial;
    }

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
