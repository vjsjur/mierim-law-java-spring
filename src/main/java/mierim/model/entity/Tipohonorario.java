package mierim.model.entity;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cad_tipo_honorario")
public class Tipohonorario implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String descricao;
    private String status;
    private String hora;
    private String fixo;
    private String limite_fatura;
    private String limite_geral;
    private String faixa;
    private String valor_minimo;
     private String valor_faixa;
    private String cobravel;
    private String qtd_processo;
    private String parc_automatica;
    private String deletado = "2";

    public Tipohonorario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor_minimo() {
        return valor_minimo;
    }

    public void setValor_minimo(String valor_minimo) {
        this.valor_minimo = valor_minimo;
    }

    public String getValor_faixa() {
        return valor_faixa;
    }

    public void setValor_faixa(String valor_faixa) {
        this.valor_faixa = valor_faixa;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public String getLimite_fatura() {
        return limite_fatura;
    }

    public void setLimite_fatura(String limite_fatura) {
        this.limite_fatura = limite_fatura;
    }

    public String getLimite_geral() {
        return limite_geral;
    }

    public void setLimite_geral(String limite_geral) {
        this.limite_geral = limite_geral;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getQtd_processo() {
        return qtd_processo;
    }

    public void setQtd_processo(String qtd_processo) {
        this.qtd_processo = qtd_processo;
    }

    public String getParc_automatica() {
        return parc_automatica;
    }

    public void setParc_automatica(String parc_automatica) {
        this.parc_automatica = parc_automatica;
    }

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

    public String getCobravel() {
        return cobravel;
    }

    public void setCobravel(String cobravel) {
        this.cobravel = cobravel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Tipohonorario other = (Tipohonorario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
