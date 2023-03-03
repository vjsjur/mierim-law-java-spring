package mierim.model.entity;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

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
    private String status;
    private String deletado = "2";
    private Double quilometragem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    @NotEmpty(message = "PREENCHA O STATUS!")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getCliente_codigo() {
        return cliente_codigo;
    }

    public void setCliente_codigo(String cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
    }

    public String getCliente_loja() {
        return cliente_loja;
    }

    public void setCliente_loja(String cliente_loja) {
        this.cliente_loja = cliente_loja;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

}
