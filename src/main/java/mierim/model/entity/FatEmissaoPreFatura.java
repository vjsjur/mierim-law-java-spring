package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "fat_emissao_prefatura")
public class FatEmissaoPreFatura implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_ts = new Date(19000101);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_ts = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_tab = new Date(01 / 01 / 1900);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_tab = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_desp = new Date(01 / 01 / 1900);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_desp = new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_ini_fx = new Date(01 / 01 / 1900);

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim_fx = new Date();

    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Profissional socio;

    @ManyToOne
    @JoinColumn(name = "id_revisor")
    private Profissional revisor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "id_grupo_cliente")
    private Grupocliente grupocliente;

    @ManyToOne
    @JoinColumn(name = "id_despesa_tipo")
    private DespesaTipo despesatipo;

    @ManyToOne
    @JoinColumn(name = "id_honorario_tipo")
    private Tipohonorario tipohonorario;
    private String deletado = "2";
    private boolean tem_timesheet ;
    private boolean tem_despesa ;
    private boolean tem_tabelado ;
    private boolean tem_fixo ;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final FatEmissaoPreFatura other = (FatEmissaoPreFatura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
