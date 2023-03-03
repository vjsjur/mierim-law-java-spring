package mierim.model.entity;

/**
 * @author Vagner J Santos (VJS)
 * @Date 20190921
 * @version 2020.0.0
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

@Entity(name = "cad_profissional_historico")
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"ano_mes_ini","ano_mes_fim", "id_profissional", "deletado"}, name = "historico_prof_uk"))
public class Historicoprofissional implements Serializable {

    private static final long serialVersionUID = 5106253941744225597L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    @Id
    private String ano_mes_ini;
    private String ano_mes_fim;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_admissao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_demissao;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "id_centro_custo")
    private Centrocusto centrocusto;
    private String part_distribuicao;
    private String socio;
    private String participa_rateio_despesa;
    private String tecnico;
    private String tempo_disponivel;
    private String deletado = "2";

    public Profissional getProfissional() {
        return profissional;
    }


    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Date getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Date data_demissao) {
        this.data_demissao = data_demissao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Escritorio getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Centrocusto getCentrocusto() {
        return centrocusto;
    }

    public void setCentrocusto(Centrocusto centrocusto) {
        this.centrocusto = centrocusto;
    }

    public String getPart_distrinuicao() {
        return part_distribuicao;
    }

    public void setPart_distrinuicao(String part_distribuicao) {
        this.part_distribuicao = part_distribuicao;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getParticipa_rateio_despesa() {
        return participa_rateio_despesa;
    }

    public void setParticipa_rateio_despesa(String participa_rateio_despesa) {
        this.participa_rateio_despesa = participa_rateio_despesa;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getTempo_disponivel() {
        return tempo_disponivel;
    }

    public void setTempo_disponivel(String tempo_disponivel) {
        this.tempo_disponivel = tempo_disponivel;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public String getAno_mes_ini() {
        return ano_mes_ini;
    }

    public void setAno_mes_ini(String ano_mes_ini) {
        this.ano_mes_ini = ano_mes_ini;
    }

    public String getAno_mes_fim() {
        return ano_mes_fim;
    }

    public void setAno_mes_fim(String ano_mes_fim) {
        this.ano_mes_fim = ano_mes_fim;
    }

    public String getPart_distribuicao() {
        return part_distribuicao;
    }

    public void setPart_distribuicao(String part_distribuicao) {
        this.part_distribuicao = part_distribuicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ano_mes_ini);
        hash = 67 * hash + Objects.hashCode(this.ano_mes_fim);
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
        final Historicoprofissional other = (Historicoprofissional) obj;
        if (!Objects.equals(this.ano_mes_ini, other.ano_mes_ini)) {
            return false;
        }
        if (!Objects.equals(this.ano_mes_fim, other.ano_mes_fim)) {
            return false;
        }
        return true;
    }

   
}
