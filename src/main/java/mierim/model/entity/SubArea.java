package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_subarea_juridica")
public class SubArea implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    @Column(name = "codigo", unique = true, length = 10)
    private String codigo;
    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    @Column(name = "descricao", length = 80)
    private String descricao;
    @NotNull(message = "PREENCHA A DATA!")
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_cadastro")
    private Date dt_cadastro = new Date();
    @NotNull(message = "PREENCHA A ÁREA!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_area")
    private Area area;
    @Column(name = "status", length = 1)
    private String status;
    @NotNull(message = "PREENCHA O TIPO ÁREA!")
    @Column(name = "tecnico", length = 1)
    private String tecnico;
    @Column(name = "deletado", length = 1)
    private String deletado = "2";

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
        final SubArea other = (SubArea) obj;
        return Objects.equals(this.id, other.id);
    }

}
