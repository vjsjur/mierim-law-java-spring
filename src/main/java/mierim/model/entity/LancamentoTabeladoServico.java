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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotEmpty;

@Entity(name = "cad_lancamento_tabelado_servico")
public class LancamentoTabeladoServico implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;
    private String inpi;
    private String descricao;
    private String narrativa;
    private String lanca_timesheet;
    private String cobra_maior;
    private String status;
    private String deletado = "2";
    @ManyToOne
    @JoinColumn(name = "id_despesa_tipo")
    private DespesaTipo despesa_tipo;
    private Integer despesa_tipo_codigo;
    @ManyToOne
    @JoinColumn(name = "id_lancamento_tabelado_tipo")
    private LancamentoTabeladoTipo lancamento_tabelado_tipo;
    private Integer lancamento_tabelado_tipo_codigo;

    public LancamentoTabeladoServico() {
    }

    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInpi() {
        return inpi;
    }

    public void setInpi(String inpi) {
        this.inpi = inpi;
    }

    public String getNarrativa() {
        return narrativa;
    }

    public void setNarrativa(String narrativa) {
        this.narrativa = narrativa;
    }

    public DespesaTipo getDespesa_tipo() {
        return despesa_tipo;
    }

    public void setDespesa_tipo(DespesaTipo despesa_tipo) {
        this.despesa_tipo = despesa_tipo;
    }

    public Integer getDespesa_tipo_codigo() {
        return despesa_tipo_codigo;
    }

    public void setDespesa_tipo_codigo(Integer despesa_tipo_codigo) {
        this.despesa_tipo_codigo = despesa_tipo_codigo;
    }

    public LancamentoTabeladoTipo getLancamento_tabelado_tipo() {
        return lancamento_tabelado_tipo;
    }

    public void setLancamento_tabelado_tipo(LancamentoTabeladoTipo lancamento_tabelado_tipo) {
        this.lancamento_tabelado_tipo = lancamento_tabelado_tipo;
    }

    public Integer getLancamento_tabelado_tipo_codigo() {
        return lancamento_tabelado_tipo_codigo;
    }

    public void setLancamento_tabelado_tipo_codigo(Integer lancamento_tabelado_tipo_codigo) {
        this.lancamento_tabelado_tipo_codigo = lancamento_tabelado_tipo_codigo;
    }

    public String getLanca_timesheet() {
        return lanca_timesheet;
    }

    public void setLanca_timesheet(String lanca_timesheet) {
        this.lanca_timesheet = lanca_timesheet;
    }

    public String getCobra_maior() {
        return cobra_maior;
    }

    public void setCobra_maior(String cobra_maior) {
        this.cobra_maior = cobra_maior;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final LancamentoTabeladoServico other = (LancamentoTabeladoServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
