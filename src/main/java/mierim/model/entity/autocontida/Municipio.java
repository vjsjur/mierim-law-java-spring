package mierim.model.entity.autocontida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
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
@Entity(name = "cad_municipio")
public class Municipio implements Serializable {

    @Id
    private Integer id;
    private Integer id_rec_status;
    private String cod_uf;
    private String sigla_uf;
    private String nome_Uf;
    private String cod_mesor_geog;
    private String nome_mesor;
    private String cod_micror_geog;
    private String nome_micror;
    private String cod_mun;
    private String cod_mun_comp;
    private String nome_mun;
    private String cod_pais;
    private String sigla_pais;
    private String nome_pais;

    public Municipio(String cod_pais, String sigla_pais, String nome_pais) {
        this.cod_pais = cod_pais;
        this.sigla_pais = sigla_pais;
        this.nome_pais = nome_pais;
    }
    public Municipio(String cod_uf, String sigla_uf, String nome_Uf, String cod_pais, String sigla_pais, String nome_pais) {
        this.cod_uf = cod_uf;
        this.sigla_uf = sigla_uf;
        this.nome_Uf = nome_Uf;
        this.cod_pais = cod_pais;
        this.sigla_pais = sigla_pais;
        this.nome_pais = nome_pais;
    }

    public Municipio(String cod_mun, String cod_mun_comp, String nome_mun, String cod_uf, String sigla_uf, String nome_Uf, String cod_pais, String sigla_pais, String nome_pais) {
        this.cod_mun = cod_mun;
        this.cod_mun_comp= cod_mun_comp;
        this.nome_mun = nome_mun;
        this.cod_uf = cod_uf;
        this.sigla_uf = sigla_uf;
        this.nome_Uf = nome_Uf;
        this.cod_pais = cod_pais;
        this.sigla_pais = sigla_pais;
        this.nome_pais = nome_pais;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
