package mierim.model.entity.faturamento;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
@Entity(name = "fat_prefatura_profissional")
public class FatPrefaturaProfissional implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(12) ZEROFILL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    private double ut;
    private String hora;

    @Column(precision = 11, scale = 8)
    private Double hora_frac;

    @ManyToOne
    @JoinColumn(name = "id_caso")
    private Caso caso;

    @Column(precision = 11, scale = 8)
    private Double valor;
    private String deletado = "2";

    @ManyToOne
    @JoinColumn(name = "id_prefatura")
    private FatPreFatura fatprefatura;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_contrato_caso")
    private ContratoCaso contrato_caso;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final FatPrefaturaProfissional other = (FatPrefaturaProfissional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
