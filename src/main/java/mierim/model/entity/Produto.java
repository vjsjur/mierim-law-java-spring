package mierim.model.entity;

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

/**
 *
 * @author Administrator
 */
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

    public Produto() {
    }

    public static final String buscarPorCodigo = "select cad_produto where id = :id";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade.toUpperCase();
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public void baixarEstoque(Integer quantidade) throws NegocioException {
        int novaQuantidade = this.getQuantidadeEstoque() - quantidade;

        if (novaQuantidade < 0) {
            throw new NegocioException("Não há disponibilidade no estoque de "
                    + quantidade + " itens do produto " + this.getSku() + ".");
        }

        this.setQuantidadeEstoque(novaQuantidade);
    }

    public void adicionarEstoque(Integer quantidade) {
        this.setQuantidadeEstoque(getQuantidadeEstoque() + quantidade);
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
