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
@Entity(name = "fat_tabelado_lancamento")
public class FatTabeladoLancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_prifissional")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contratocaso;

    @ManyToOne
    @JoinColumn(name = "id_moeda")
    private Moeda moeda;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_lancamento;
    private String status;
    private String deletado  = "2";
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura prefatura;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final FatTabeladoLancamento other = (FatTabeladoLancamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


 
}
