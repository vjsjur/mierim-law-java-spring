package mierim.model.entity.autocontida;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_municipio")
public class Municipio implements Serializable {

    @Id
    private Long id ;
    private Integer id_rec_status;
    private String cod_uf;
    private String sigla_uf;
    private String nome_uf;
    private String cod_mesor_geog;
    private String nome_mesor;
    private String cod_micror_geog;
    private String nome_micror;
    private String cod_mun;
    private String cod_mun_comp;
    private String nome_mun = "";
    private String cod_pais;
    private String sigla_pais;
    private String nome_pais;
    @JsonIgnore
    @OneToMany(mappedBy = "municipio")
    public List<Sis_CompanyEmpresa>  sis_companyEnpresa=  new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Municipio)) return false;
        Municipio municipio = (Municipio) o;
        return getId().equals(municipio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
