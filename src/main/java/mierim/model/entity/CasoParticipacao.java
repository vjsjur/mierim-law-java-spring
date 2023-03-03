package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
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
@Entity(name = "cad_caso_participacao")
public class CasoParticipacao implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Integer id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ano_mes_ini;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ano_mes_fin;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso id_caso;

    @ManyToOne
    @JoinColumn(name = "id_originacao")
    private Originacao originacao;

    @Column(name = "deletado", length = 1)
    private String deletado = "2";

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    private double percentual;

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CasoParticipacao other = (CasoParticipacao) obj;
        return Objects.equals(this.id, other.id);
    }

}
